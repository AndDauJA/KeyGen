package lt.daujotas.Users.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.sipher.Server;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import lt.daujotas.sipher.repository.IVKeyRepository;
import lt.daujotas.sipher.repository.SpecKeyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGeneralLoginCredentialsDataService {
    private final UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository;
    private final SpecKeyRepository specKeyRepository;
    private final IVKeyRepository ivKeyRepository;
    private final Server server;

    @Transactional
    public void inputKeyGenData(UserDto userDto) throws Exception {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final ClientData clientData = (ClientData) authentication.getPrincipal();

        server.init(); // Užtikrinti, kad raktas ir IV būtų sugeneruoti
        String[] encryptionResults = Server.encrypt(userDto.getGeneratedkey());
        String encryptedMessage = encryptionResults[0];
        String secrKey = encryptionResults[1];
        String iv = encryptionResults[2];

        UserGeneralLoginCredentialsData userCredentialsData = UserGeneralLoginCredentialsData.builder()

                .username(userDto.getUserNameEmail())
                .generatedkey(encryptedMessage)
                .uuid(UUID.randomUUID())
                .webaddress(userDto.getWebaddress())
                .notes(userDto.getNotes())
                .clientDataId(clientData.getId())
                .clientData(clientData)
                .build();

        userCredentialsData = userGeneralLoginCredentialsDataRepository.save(userCredentialsData);
        specKeyRepository.save(new SpecialKeyPojo(UUID.randomUUID(), secrKey, userCredentialsData));
        ivKeyRepository.save(new IVKeyPojo(UUID.randomUUID(), iv, userCredentialsData));
    }

    @Transactional
    public void deleteUserGeneralDataByUUID(UUID credentialDataId) {
        userGeneralLoginCredentialsDataRepository.deleteByUuid(credentialDataId);
    }

    public Page<UserGeneralLoginCredentialsData> getAllClientsPages(UserDto userDto, Pageable pageable) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final ClientData clientData = (ClientData) authentication.getPrincipal();
        return userGeneralLoginCredentialsDataRepository.findByClientDataId(clientData.getId(), pageable);
    }
}
