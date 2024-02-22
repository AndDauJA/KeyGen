package lt.daujotas.sipher.repository;

import lt.daujotas.sipher.pojo.IVKeyPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IVKeyRepository extends JpaRepository<IVKeyPojo, UUID> {

}
