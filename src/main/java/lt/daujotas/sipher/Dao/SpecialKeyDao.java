package lt.daujotas.sipher.Dao;

import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;

import java.util.Optional;
import java.util.UUID;

public interface SpecialKeyDao {

    void save(SpecialKeyPojo specialKeyPojo);
    Optional<SpecialKeyPojo> getKeyByUuid(UUID id);
}
