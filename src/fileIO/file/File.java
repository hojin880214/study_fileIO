package fileIO.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

    public void makeFile() {
        Path filePath = Paths.get("c:\\file.txt");
        try {
            Path newFilePath = Files.createFile(filePath);
            System.out.println(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
