package lt.daujotas.service;

import lombok.AllArgsConstructor;

import lt.daujotas.mapper.ClientMapper;
import lt.daujotas.dao.UserFirstRegistrationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {



    private final UserFirstRegistrationRepository userFirstRegistrationRepository;
    private final ClientMapper clientMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userFirstRegistrationRepository.findClientDataByUsernameWithinAndAuthorities(username)
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));

    }

//    public void saveNewClient(ClientData clientData) {
//        clientRepository.save(clientData);
//
//    }
}
