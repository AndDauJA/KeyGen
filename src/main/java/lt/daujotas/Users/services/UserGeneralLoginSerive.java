package lt.daujotas.Users.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.mapper.UserMapper;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dao.UserGeneralDao;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGeneralLoginSerive {
    private final UserGeneralDao userGeneralDao;
    private final UserMapper userMapper;
    private final UserGeneralRepository userGeneralRepository;
    public List<UserGeneralLoginCredentialsData> getAllData() {
        return userGeneralDao.getAll();
    }

    public Optional<UserDto> getClientByUUID(UUID clientUUID) {
        Optional<UserGeneralLoginCredentialsData> optionaUserLoginCredentialsInfo = userGeneralDao.getDataByUUID(clientUUID);
        if (optionaUserLoginCredentialsInfo.isPresent()) {
              UserGeneralLoginCredentialsData userGeneralLoginCredentialsData = optionaUserLoginCredentialsInfo.get();
            UserDto userDto = userMapper.toDto(userGeneralLoginCredentialsData);
            return Optional.of(userDto);
        } else {
            return Optional.empty();
        }
    }


    public void inputKeyGenData(UserDto userDto) {

        userGeneralRepository.save(
                UserGeneralLoginCredentialsData.builder()
                        .username(userDto.getUserNameEmail())
                        .generatedkey(new BCryptPasswordEncoder().encode(userDto.getGeneratedkey()))
                        .uuid(UUID.randomUUID())
                        .webaddress(userDto.getWebaddress())
                        .notes(userDto.getNotes())
                        .build()
        );


    }
    @Transactional
    public void deleteUserGeneralByUUID(UUID id) {
        userGeneralDao.deleteDataByUUID(id);
    }



    public Page<UserGeneralLoginCredentialsData> getAllClientsPages(Pageable pageable) {
        return userGeneralDao.getPage(pageable);
    }
}
