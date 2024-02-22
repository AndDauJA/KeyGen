package lt.daujotas.sipher.Dao;

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
    public Optional<IVKeyPojo> getIVKeyByUuid(UUID id) {
        return Optional.empty();
    }
}
