package lt.daujotas;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenKeySaveToFile implements Serializable {

    public static void fileOutGoing(int getKeyId) throws IOException {
        KeyGen keyGen = new KeyGen();
        var path = "./src/main/java/failai/Irasai.txt";

        try {

            var writer = new BufferedWriter(new FileWriter(path, true));
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write("Timestamp: " + timeStamp);
            writer.newLine();
            String key = keyGen.generateNoKey(0); // Replace 123 with the desired numberKey

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
