package lt.daujotas.sipher.srvice;

import lt.daujotas.sipher.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneretedKeyDecryptionService {
    private final Client client;

    @Autowired
    public GeneretedKeyDecryptionService(Client client) {
        this.client = client;
    }

    public String decryptPassword(String encryptedPassword, String secretKey, String IV) throws Exception {
        client.initFromStrings(secretKey, IV);
        return client.decrypt(encryptedPassword);
    }
}
