package lt.daujotas.service;

import lombok.AllArgsConstructor;
import lt.daujotas.Users.dao.UserDao;
import lt.daujotas.Users.repository.UserRepository;
import lt.daujotas.clients.ClientLoginInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
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
    public void register (ClientLoginInfo clientLoginInfo){
        userDao.save(clientLoginInfo);
    }
}
