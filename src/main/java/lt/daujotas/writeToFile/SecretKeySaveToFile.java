package lt.daujotas.writeToFile;

import lt.daujotas.sipher.Server;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SecretKeySaveToFile implements Serializable {
    private static int lastId = 1;

    public static void fileOutGoing() throws Exception {
        Server server = new Server();
        server.init();
        var path = "./src/main/java/failai/alfakey.txt";

        try {
//            int lastId = getLastId(path);
//            int newId = lastId + 1;
            var writer = new BufferedWriter(new FileWriter(path, true));
//            writer.write(newId); // Rašome ID kaip tekstą
//            writer.newLine();
            String key = server.exportSecretKeys();
            writer.write(key);
            writer.newLine();
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static int getLastId(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lastId = 0;
            // Einame per visą failą ir nuskaitome paskutinį ID
            while ((line = reader.readLine()) != null) {
                lastId = Integer.parseInt(line.trim());
            }
            return lastId;
        }
    }


}
