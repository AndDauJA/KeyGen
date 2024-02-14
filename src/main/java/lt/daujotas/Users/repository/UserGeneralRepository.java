package lt.daujotas.Users.repository;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserGeneralRepository extends JpaRepository<UserGeneralLoginCredentialsData, UUID> {
    Optional<UserGeneralLoginCredentialsData> findClientLoginCredentialsDataByUuid(UUID id);
    void deleteUserGeneralLoginCredentialsDataByUuid (UUID loginId);
}
