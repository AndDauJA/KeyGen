package lt.daujotas.sipher.repository;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SpecKeyRepository extends JpaRepository<SpecialKeyPojo, Long> {
Optional<SpecialKeyPojo>findByUserGeneralLoginCredentialsData (UserGeneralLoginCredentialsData userGeneralLoginCredentialsData);
    Optional<SpecialKeyPojo> findByUserGeneralLoginCredentialsDataUuid(UUID uuid);
}
