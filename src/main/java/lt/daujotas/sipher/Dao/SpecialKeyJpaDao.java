package lt.daujotas.sipher.Dao;

import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import lt.daujotas.sipher.repository.SpecKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SpecialKeyJpaDao implements SpecialKeyDao {
    private final SpecKeyRepository specKeyRepository;

    @Autowired
    public SpecialKeyJpaDao(SpecKeyRepository specKeyRepository) {
        this.specKeyRepository = specKeyRepository;
    }

    @Override
    public void save(SpecialKeyPojo specialKeyPojo) {
        specialKeyPojo.setSpecKeyId(UUID.randomUUID());
        specKeyRepository.save(specialKeyPojo);
    }

    @Override
    public Optional<SpecialKeyPojo> getKeyByUuid(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<SpecialKeyPojo> getSecretKeyByCredentialId(UUID credentialDataId) {
        return specKeyRepository.findByUserGeneralLoginCredentialsDataUuid(credentialDataId);
    }

}
