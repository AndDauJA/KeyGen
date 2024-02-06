package lt.daujotas.service;

import lombok.AllArgsConstructor;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.Users.dao.UserDao;
import lt.daujotas.dao.ClientRepository;
import lt.daujotas.dao.UserFirstRegistrationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private final ClientRepository clientRepository;
    private final UserFirstRegistrationRepository userFirstRegistrationRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userFirstRegistrationRepository.findClientDtoByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("'" + username + "' not found!"));

    }

//    public void register(ClientLoginInfo clientLoginInfo) {
//        userRepository.save(
//                ClientLoginInfo.builder()
//                        .username(clientLoginInfo.getUsername())
//                        .password(new BCryptPasswordEncoder().encode(clientLoginInfo.getPassword()))
//                        .build()
//        );
//    }
//    public void register (ClientLoginInfo clientLoginInfo){
//        userDao.save(clientLoginInfo);
//    }
public void saveNewClient(ClientData clientData){
        clientRepository.save(clientData);

}
}
