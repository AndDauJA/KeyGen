package lt.daujotas.Users.Controlers;

import lt.daujotas.KeyGen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyGenerationController {
    @GetMapping("/generate-key-lorem")
    public String generateKeyLorem(@RequestParam("noOfRandomChars") int noOfRandomChars) {


        String generatedKeyLorem=KeyGen.generateLoremIps(noOfRandomChars);
        return generatedKeyLorem;
    }
    @GetMapping("/generate-key-letters")
    public String generateKey(@RequestParam("noOfRandomChars") int noOfRandomChars) {

        String generatedKey = KeyGen.generateNoKey(noOfRandomChars);

        return generatedKey;
    }
    @GetMapping("/generate-key-special")
    public String generateKeySpecial(@RequestParam("noOfRandomChars") int noOfRandomChars) {

        String generatedKeySpecial = KeyGen.generatespecKey(noOfRandomChars);

        return generatedKeySpecial;
    }
    @GetMapping("/generate-key-special-letters")
    public String generateKeySpecialLetters(@RequestParam("noOfRandomChars") int noOfRandomChars) {

        String generatedKeySpecialLetters = KeyGen.generatespecKey(noOfRandomChars)+KeyGen.generateNoKey(noOfRandomChars);

        return generatedKeySpecialLetters;
    }

}
