package lt.daujotas.Users.repository;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserGeneralLoginCredentialsDataRepository extends JpaRepository<UserGeneralLoginCredentialsData, UUID> {
    Optional<UserGeneralLoginCredentialsData> findClientLoginCredentialsDataByUuid(UUID id);

    void deleteUserGeneralLoginCredentialsDataByUuid(UUID loginId);

    void deleteByUuid(UUID uuid);

    Page<UserGeneralLoginCredentialsData> findByClientDataId(Long id,
                                                             Pageable pageable);
}
