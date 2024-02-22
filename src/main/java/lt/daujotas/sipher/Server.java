package lt.daujotas.sipher;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */
@Component
public class Server {
    private SecretKey key;
    private static int KEY_SIZE = 128;
    private static final String ALGORITHM = "AES";
    private int T_LEN = 128;
    private Cipher encryptionCipher;
    private byte[] IV;
    Client client = new Client();

    public static String[] encryptPassword(String password) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        String encryptedPassword = Base64.getEncoder().encodeToString(encryptedBytes);
        String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        return new String[]{encryptedPassword, secretKeyString, encode(generateIV())};
    }

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
        IV = generateIV();
    }

    private static byte[] generateIV() {
        byte[] iv = new byte[KEY_SIZE / 8];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    public void initFromStrings(String secretKey, String IV) {
        key = new SecretKeySpec(decode(secretKey), "AES");
        this.IV = decode(IV);
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        IV = encryptionCipher.getIV();
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    public String exportSecretKeys() {

        return encode(key.getEncoded());
    }

    public String exportKeyIV() {
        return encode(IV);
    }

//    public String getMessageEncripted() throws Exception {
//        return encrypt(client.getMessage());
//    }

    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

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
//            server.initFromStrings(secrKey, iv);
//
////            String encryptedMessage = server.encrypt(mesage);
////            System.err.println("Encrypted Message : " + encryptedMessage);
//        } catch (Exception ignored) {
//        }
//    }

//    public static void main(String[] args) {
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
//            server.initFromStrings(secrKey, iv);
//
////            String encryptedMessage = server.encrypt(mesage);
////            System.err.println("Encrypted Message : " + encryptedMessage);
//        } catch (Exception ignored) {
//        }
//    }
}
