package lt.daujotas.sipher;

import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */
@Component
public class Server {
    private static SecretKey key;
    private static int KEY_SIZE = 128;
    private static final String ALGORITHM = "AES";
    private int T_LEN = 128;
    private static Cipher encryptionCipher;
    private static byte[] IV;


    public static String[] encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        IV = encryptionCipher.getIV(); // Užtikrinti, kad IV būtų priskirtas čia
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        String encryptedMessage = encode(encryptedBytes);
        String encodedKey = encode(key.getEncoded());
        String encodedIV = encode(IV);
        return new String[]{encryptedMessage, encodedKey, encodedIV}; // Grąžina užšifruotą žinutę, šifravimo raktą ir IV
    }

    public SecretKey generateKey() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
        IV = generateIV();
        return generator.generateKey();
    }

    public void init() throws Exception {
        key = generateKey();
        IV = generateIV();
    }

    public static byte[] generateIV() {
        byte[] iv = new byte[KEY_SIZE / 8];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

//    =================================Get Message to encode=============
//    public String getMessageEncripted() throws Exception {
//        return encrypt(client.getMessage());
//    }

    //=========================================================== EXPORT
    public String exportSecretKeys() {

        return encode(key.getEncoded());
    }

    public String exportKeyIV() {
        return encode(IV);
    }
//===============================================================Export


//    public void initFromStrings(String secretKey, String IV) {
//        key = new SecretKeySpec(decode(secretKey), "AES");
//        this.IV = decode(IV);
//    }

//    private byte[] decode(String data) {
//        return Base64.getDecoder().decode(data);
//    }

//    public static void runEncoding() {
//        Server server = new Server();
//
//        try {
//            server.init();
//            String mesage = server.getMessageEncripted();
//            System.out.println("encrypt message: " + mesage);
//            String secrKey = server.exportSecretKeys();
//            System.out.println("secret key: " + secrKey);
//            String iv = server.exportKeyIV();
//            System.out.println("IV: " + iv);
////            server.initFromStrings(secrKey, iv);
//
////            String encryptedMessage = server.encrypt(mesage);
////            System.err.println("Encrypted Message : " + encryptedMessage);
//        } catch (Exception ignored) {
//        }
//    }


//    public static void main(String[] args) throws Exception {
//        Server server = new Server();
////        Encoding.runEncoding();
//        try {
//            server.init();
//            String mesage = server.getMessageEncripted();
//            System.out.println("encrypt message: " + mesage);
//            String secrKey = server.exportSecretKeys();
//            System.out.println("secret key: " + secrKey);
//            String iv = server.exportKeyIV();
//            System.out.println("IV: " + iv);
////            server.initFromStrings(secrKey, iv);
//
////            String encryptedMessage = server.encrypt(mesage);
////            System.err.println("Encrypted Message : " + encryptedMessage);
//        } catch (Exception ignored) {
//        }
////    }
//    }
}

