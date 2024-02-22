package lt.daujotas.readFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {


    public static String ReadSecretKeyFromFile() throws IOException {
        String filePath = "./src/main/java/failai/alfakey.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
//                int id = Integer.parseInt(line.trim());
//                if (id == targetId) {
                    // Rasta eilutė su norimu ID, paimame sekanti eilutę kaip rakto reikšmę
                    return reader.readLine();
//                }
            }
        }
        // Jei nerasta rakto reikšmė su nurodytu ID, grąžiname null
        return null;
    }


}



