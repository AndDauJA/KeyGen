package lt.daujotas.sipher.srvice;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.dao.ClientRepository;
import lt.daujotas.sipher.Client;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import lt.daujotas.sipher.repository.IVKeyRepository;
import lt.daujotas.sipher.repository.SpecKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DecodingGenKeyService {
    private final UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository;

    private final ClientRepository clientRepository;
    private final SpecKeyRepository specKeyRepository;
    private final IVKeyRepository ivKeyRepository;
    private final Client client;

    @Autowired
    public DecodingGenKeyService(UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository, ClientRepository clientRepository, SpecKeyRepository specKeyRepository, IVKeyRepository ivKeyRepository, Client client) {
        this.userGeneralLoginCredentialsDataRepository = userGeneralLoginCredentialsDataRepository;
        this.clientRepository = clientRepository;
        this.specKeyRepository = specKeyRepository;
        this.ivKeyRepository = ivKeyRepository;
        this.client = client;
    }

    public String decryptMessage(UUID credentialDataId) throws Exception {
        // Čia paimkite užšifruotą žinutę ir atitinkamus šifravimo raktus ir IV iš duomenų bazės
        UserGeneralLoginCredentialsData credentialsData = userGeneralLoginCredentialsDataRepository.findClientLoginCredentialsDataByUuid(credentialDataId).orElse(null);
        if (credentialsData == null) {
            return "Credentials not found";
        }
        Optional<SpecialKeyPojo> specKey = specKeyRepository.findByUserGeneralLoginCredentialsData(credentialsData);
        Optional<IVKeyPojo> ivKey = ivKeyRepository.findByUserGeneralLoginCredentialsData(credentialsData);

        if (!specKey.isPresent() || !ivKey.isPresent()) {
            return "Encryption key or IV not found";
        }
        // Naudokite Client klasę dekodavimui
        client.initFromStrings(specKey.get().getSecretKey(), ivKey.get().getSpecialIVKey());
        return client.decrypt(credentialsData.getGeneratedkey());
    }

    // Naudoju metoda ivedimui i html
    public List<UserDto> getUsersWithDecryptedKeysForClient(Long clientId, Pageable pageable) {

        Page<UserGeneralLoginCredentialsData> credentialsPage = userGeneralLoginCredentialsDataRepository.findByClientDataId(clientId, pageable);

        return credentialsPage.stream().map(credentials -> {
            UserDto dto = new UserDto();
            dto.setUuid(credentials.getUuid());
            dto.setUserNameEmail(credentials.getUsername());
            dto.setGeneratedkey(credentials.getGeneratedkey());
            dto.setWebaddress(credentials.getWebaddress());
            dto.setNotes(credentials.getNotes());
            dto.setDateAdded(credentials.getDateAdded());
            try {
                dto.setDecryptedKey(decryptMessage(credentials.getUuid()));
            } catch (Exception e) {
                dto.setDecryptedKey("Error decrypting key");
            }
            return dto;
        }).collect(Collectors.toList());

    }
    public List<UserDto> hideTheGeneratedKey(Long clientId, Pageable pageable){
        List<UserDto> userDtoList = getUsersWithDecryptedKeysForClient(clientId, pageable);
        userDtoList.forEach(dto -> dto.setDecryptedKey("**********"));

        return userDtoList;
    }

}
