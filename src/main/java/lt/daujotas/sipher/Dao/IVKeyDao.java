package lt.daujotas.sipher.Dao;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;

import java.util.Optional;
import java.util.UUID;

public interface IVKeyDao {
    void save(IVKeyPojo ivKeyPojo);
    Optional<IVKeyPojo> getIVKeyByCredentialId(UserGeneralLoginCredentialsData userGeneralLoginCredentialsData);

    Optional<IVKeyPojo> getIVKeyByCredentialId(UUID uuid);
}
