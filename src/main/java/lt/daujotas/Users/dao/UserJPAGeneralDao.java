package lt.daujotas.Users.dao;


import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserJPAGeneralDao implements UserGeneralDao {

    private final UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository;

    @Autowired
    public UserJPAGeneralDao(UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository) {
        this.userGeneralLoginCredentialsDataRepository = userGeneralLoginCredentialsDataRepository;
    }

    @Override
    public void save(UserGeneralLoginCredentialsData userGeneralLoginCredentialsData) {

        userGeneralLoginCredentialsDataRepository.save(userGeneralLoginCredentialsData);
    }

    @Override
    public void update(UserGeneralLoginCredentialsData userGeneralLoginCredentialsData) {
        Optional<UserGeneralLoginCredentialsData> savedOptionalUser = getDataByUUID(userGeneralLoginCredentialsData.getUuid());
        if (savedOptionalUser.isPresent()) {

            UserGeneralLoginCredentialsData savedByUserUuid = savedOptionalUser.get();
            savedByUserUuid.setUuid(userGeneralLoginCredentialsData.getUuid());
//             user.setPassword("newPassword");

            userGeneralLoginCredentialsDataRepository.save(savedByUserUuid);
        }
    }

    @Override
    public List<UserGeneralLoginCredentialsData> getAll() {
        return userGeneralLoginCredentialsDataRepository.findAll();
    }

    @Override
    public Optional<UserGeneralLoginCredentialsData> getDataByUUID(UUID id) {
        return userGeneralLoginCredentialsDataRepository.findById(id);
    }

    @Override
    public void deleteDataByUUID(UUID id) {
        Optional<UserGeneralLoginCredentialsData> userGeneralLogin = userGeneralLoginCredentialsDataRepository.findById(id);
        userGeneralLogin.ifPresent(userGeneralLoginCredentialsDataRepository::delete);
    }

    @Override
    public void deleteByClientUserName(String userName) {

    }

    @Override
    public Page<UserGeneralLoginCredentialsData> getPage(Pageable pageable) {
        return userGeneralLoginCredentialsDataRepository.findAll(pageable);
    }


//    @Override
//    public void save(ClientLoginInfo clientLoginInfo) {
//        userRepository.save(clientLoginInfo);
//    }

}
