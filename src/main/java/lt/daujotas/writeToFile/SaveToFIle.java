package lt.daujotas.writeToFile;

import lt.daujotas.KeyGen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveToFIle implements Serializable {


    public static void fileOutGoing() throws Exception {
        var path = "./src/main/java/failai/irasai.txt";

        try {

            var writer = new BufferedWriter(new FileWriter(path, true));
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            writer.write(timeStamp);
            writer.newLine();
            String key = KeyGen.generateNoKey(2); // Replace 123 with the desired numberKey

            // Write the key to the file
            writer.write(key);
            writer.newLine();
            writer.flush();

            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}






