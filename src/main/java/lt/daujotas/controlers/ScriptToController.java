package lt.daujotas.controlers;

import lt.daujotas.KeyGen;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScriptToController {

    @PostMapping("/generate-key")
    public String generateKey(
            @RequestParam(value = "generateType", required = false) String[] generateTypes,
            @RequestParam("noOfRandomChars") int noOfRandomChars) {
        // Čia apdorokite generateTypes, kuris yra masyvas su pažymėtais tipais
        // ir grąžinkite atitinkamai sugeneruotą raktą
        String generatedKey = ""; // Sugeneruoto rakto logika
        for (String type : generateTypes) {
            switch (type) {
                case "LoremIps":
                    generatedKey += KeyGen.generateLoremIps(noOfRandomChars);
                    break;
                case "lettersnumbers":
                    generatedKey += KeyGen.generateNoKey(noOfRandomChars);
                    break;
                case "Special_Key":
                    generatedKey += KeyGen.generatespecKey(noOfRandomChars);
                    break;
                // Papildyti kitais atvejais pagal poreikį
            }
        }
        return generatedKey; // Grąžinti sugeneruotą raktą
    }
}
