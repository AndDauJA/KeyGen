package lt.daujotas.sipher;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */

public class Client {
    private SecretKey key;
    private int KEY_SIZE = 128;
    private int T_LEN = 128;
    private byte[] IV;
    private Cipher encryptionCipher;

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    public void initFromStrings(String secretKey, String IV) {
        key = new SecretKeySpec(decode(secretKey), "AES");
        this.IV = decode(IV);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);

        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }

    public String getMessage() {
        return "labas";
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }


//        try {
//            server.init();
//            String mesage=server.getMessageEncripted();
////            System.out.println("encrypt message: "+mesage);
//            String secrKey = server.exportSecretKeys();
////            System.out.println("secret key: "+secrKey);
//            String iv = server.exportKeyIV();
////            System.out.println("IV: "+iv);
//            server.initFromStrings(secrKey, iv);
//
//
//            client.initFromStrings(secrKey,iv);
//            String decryptedMessage = client.decrypt(mesage);
//            System.err.println("Decrypted Message : " + decryptedMessage);
//        } catch (Exception ignored) {
//        }


}