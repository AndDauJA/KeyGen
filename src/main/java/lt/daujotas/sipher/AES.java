package lt.daujotas.sipher;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */

public class AES {
    private static SecretKey key;
    private final int KEY_SIZE = 128;
    private final int T_LEN = 128;
    private Cipher encryptionCipher;
    private byte[] IV;

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        IV = encryptionCipher.getIV();
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }

    private static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String exportSecretKeys() {

//        System.err.println("IV: " + encode(IV));
        return encode(key.getEncoded());
    }

    public String exportKeyIV() {
        return encode(IV);
    }

    public String encriptedMessage(String nameMessage) throws Exception {
        return encrypt(nameMessage);
    }

    public static void main(String[] args) throws Exception {

//        try {
//            Server server = new Server();
//            server.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");
//            String encryptedMessage = server.encrypt("TheXCoders_2");
//            System.err.println("Encrypted Message : " + encryptedMessage);
//        } catch (Exception ignored) {
//        }
//        try {
//            AES aes = new AES();
//            aes.initFromStrings("38oskpgEmTOZCHlmjpFnqg==", "124M+To7dHTo4moD8uh/xg==");
//            String decryptedMessage = .decrypt("TFf4bnfvr2RhmvBbKYPgog==");
//            System.err.println("Decrypted Message : " + decryptedMessage);
//        } catch (Exception ignored) {
//        }

        try {
            AES aes = new AES();
            aes.init();
//            String encryptedMessage = aes.encrypt(aes.getMessage());
            String decryptedMessage = aes.decrypt("TFf4bnfvr2RhmvBbKYPgog==");
//
//            System.err.println("Encrypted Message : " + encryptedMessage);
            System.err.println("Decrypted Message : " + decryptedMessage);
            System.err.println("secretkey: " + aes.exportSecretKeys());
            System.err.println("IV: " + aes.exportKeyIV());
        } catch (Exception ignored) {

        }

    }
}
