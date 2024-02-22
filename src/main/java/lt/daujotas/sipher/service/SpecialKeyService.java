package lt.daujotas.sipher.service;

import lombok.RequiredArgsConstructor;
import lt.daujotas.sipher.Dao.SpecialKeyDao;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecialKeyService {

    private final SpecialKeyDao specialKeyDao;


    public void save(SpecialKeyPojo specialKeyPojo) throws DataIntegrityViolationException {

        specialKeyDao.save(
                SpecialKeyPojo.builder()
                        .specKeyId(UUID.randomUUID())
                        .secretKey(specialKeyPojo.getSecretKey())
                        .build());


    }


}
