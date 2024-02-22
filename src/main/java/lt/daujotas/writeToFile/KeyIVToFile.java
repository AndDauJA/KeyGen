package lt.daujotas.writeToFile;

import lt.daujotas.sipher.Server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class KeyIVToFile {
    private static int lastId = 0;

    public static void fileOutGoing() throws Exception {
        Server server = new Server();
        server.init();
        var path = "./src/main/java/failai/fourkey.txt";

        try {

            var writer = new BufferedWriter(new FileWriter(path, true));
//            int id = ++lastId;
//            writer.write(id);
//            writer.newLine();
            String key = server.exportKeyIV();
            writer.write(key);
            writer.newLine();
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
