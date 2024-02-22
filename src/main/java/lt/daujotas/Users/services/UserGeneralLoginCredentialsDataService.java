package lt.daujotas.Users.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.sipher.Client;
import lt.daujotas.sipher.Dao.IVKeyDao;
import lt.daujotas.sipher.Dao.IVKeyJpaDao;
import lt.daujotas.sipher.Dao.SpecialKeyDao;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import lt.daujotas.sipher.repository.IVKeyRepository;
import lt.daujotas.sipher.repository.SpecKeyRepository;
import lt.daujotas.sipher.srvice.GeneretedKeyDecryptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static lt.daujotas.sipher.Server.encryptPassword;

@Service
@RequiredArgsConstructor
public class UserGeneralLoginCredentialsDataService {
    private final UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository;
    private final SpecKeyRepository specKeyRepository;
    private final IVKeyRepository ivKeyRepository;
    private final SpecialKeyDao specialKeyDao;
    private final IVKeyDao ivKeyDao;
    private final GeneretedKeyDecryptionService generetedKeyDecryptionService;

    public void inputKeyGenData(UserDto userDto) throws Exception {
//        String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getGeneratedkey());
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final ClientData clientData = (ClientData) authentication.getPrincipal();
        String[] encryptionData = encryptPassword(userDto.getGeneratedkey());
        String encryptedPassword = encryptionData[0];
        String secretKey = encryptionData[1];
        String IV = encryptionData[2];
//        SecretKeySaveToFile.fileOutGoing();
//        KeyIVToFile.fileOutGoing();
        UserGeneralLoginCredentialsData userCredentialsData = UserGeneralLoginCredentialsData.builder()

                .username(userDto.getUserNameEmail())
                .generatedkey(encryptedPassword)
                .uuid(UUID.randomUUID())
                .webaddress(userDto.getWebaddress())
                .notes(userDto.getNotes())
                .clientDataId(clientData.getId())
                .build();

        userCredentialsData = userGeneralLoginCredentialsDataRepository.save(userCredentialsData);

        specKeyRepository.save(
                SpecialKeyPojo.builder()
                        .specKeyId(UUID.randomUUID())
                        .secretKey(secretKey)
                        .userGeneralLoginCredentialsData(userCredentialsData)
                        .build()
        );

        ivKeyRepository.save(
                IVKeyPojo.builder()
                        .IVKeyId(UUID.randomUUID())
                        .specialIVKey(IV)
                        .userGeneralLoginCredentialsData((userCredentialsData))
                        .build()
        );
        String decryptedPassword = generetedKeyDecryptionService.decryptPassword(encryptedPassword, secretKey, IV);
    }

//    public String decryptPassword(String encryptedPassword, String secretKey, String IV) throws Exception {
//        Client client = new Client();
//        client.init();
//        client.initFromStrings(secretKey, IV);
//        return client.decrypt(encryptedPassword);
//    }

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
