package lt.daujotas.sipher.Dao;

import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.repository.IVKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class IVKeyJpaDao implements IVKeyDao {
    private final IVKeyRepository ivKeyRepository;

    @Autowired
    public IVKeyJpaDao(IVKeyRepository ivKeyRepository) {
        this.ivKeyRepository = ivKeyRepository;
    }

    @Override
    public void save(IVKeyPojo ivKeyPojo) {
        ivKeyPojo.setIVKeyId(UUID.randomUUID());
        ivKeyRepository.save(ivKeyPojo);
    }

    @Override
    public Optional<IVKeyPojo> getIVKeyByCredentialId(UserGeneralLoginCredentialsData credentialDataId) {
        return ivKeyRepository.findByUserGeneralLoginCredentialsDataUuid(credentialDataId.getUuid());
    }

    @Override
    public Optional<IVKeyPojo> getIVKeyByCredentialId(UUID uuid) {
        return ivKeyRepository.findByUserGeneralLoginCredentialsDataUuid(uuid);
    }
}
