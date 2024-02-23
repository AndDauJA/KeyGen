package lt.daujotas.sipher.repository;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IVKeyRepository extends JpaRepository<IVKeyPojo, Long> {
    Optional<IVKeyPojo> findByUserGeneralLoginCredentialsDataUuid(UUID uuid);
    Optional<IVKeyPojo>findByUserGeneralLoginCredentialsDataUuid (UserGeneralLoginCredentialsData userGeneralLoginCredentialsData);
Optional<IVKeyPojo> findByUserGeneralLoginCredentialsData(UserGeneralLoginCredentialsData userGeneralLoginCredentialsData);
}
