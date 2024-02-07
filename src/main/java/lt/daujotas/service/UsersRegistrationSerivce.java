package lt.daujotas.service;

import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientData.Autohority;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.dao.ClientRepository;
import lt.daujotas.dto.ClientDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersRegistrationSerivce {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    public void register(ClientDto clientDto) {
        clientRepository.save(
                ClientData.builder()
                        .userName(clientDto.getUserName())
                        .password(new BCryptPasswordEncoder().encode(clientDto.getPassword()))
                        .emailAddress(clientDto.getEmailAddress())
                        .firstName(clientDto.getFirstName())
                        .lastName(clientDto.getLastName())
                        .middleName(clientDto.getMiddleName())
                        .dateofbirth(clientDto.getDateofbirth())
                        .phoneNumber(clientDto.getPhoneNumber())
                        .postAddres(clientDto.getPostAddres())
                        .gender(clientDto.getGender())
                        .accountUuid(UUID.randomUUID())
                        .authorities(Set.of(Autohority.builder()
                                .userName("USER").build()))
                        .build()
        );
    }

}
