package lt.daujotas.service;

import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientDataPojo.Authority;
import lt.daujotas.Users.clientDataPojo.ClientData;
import lt.daujotas.Users.repository.AuthorityRepository;
import lt.daujotas.dao.ClientRepository;
import lt.daujotas.dao.UserFirstRegistrationRepository;
import lt.daujotas.dto.ClientDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersRegistrationSerivce {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final UserFirstRegistrationRepository userFirstRegistrationRepository;
    private final AuthorityRepository authorityRepository;

    public void register(ClientDto clientDto) throws DataIntegrityViolationException {
        final Set<Authority> authorities = authorityRepository.findAll().stream()
                .filter(authority -> authority.getName().equals("USER"))
                .collect(Collectors.toSet());

        if (authorities.isEmpty()) {
            Authority defaultAuthority = new Authority();
            defaultAuthority.setName("USER");
            authorities.add(defaultAuthority);
        }
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
                        .authorities(authorities)
                        .build()
        );
    }

}
