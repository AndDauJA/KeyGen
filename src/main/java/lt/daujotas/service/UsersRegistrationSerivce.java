package lt.daujotas.service;

import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.dao.ClientRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersRegistrationSerivce {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    public void register(ClientData clientData) {
        clientRepository.save(
                ClientData.builder()
                        .userName(clientData.getUsername())
                        .password(new BCryptPasswordEncoder().encode(clientData.getPassword()))
                        .emailAddress(clientData.getEmailAddress())
                        .firstName(clientData.getFirstName())
                        .lastName(clientData.getLastName())
                        .middleName(clientData.getMiddleName())
                        .dateofbirth(clientData.getDateofbirth())
                        .phoneNumber(clientData.getPhoneNumber())
                        .postAddres(clientData.getPostAddres())
                        .gender(clientData.getGender())
                        .accountUuid(UUID.randomUUID())
                        .build()
        );
    }

}
