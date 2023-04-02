package linkedinlearning.workingwithfiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NewBufferedWriterTest {

    public static void main(String[] args) {

        String currentPath = System.getProperty("user.dir") + "/myDirectory/test.txt";
        System.out.println(currentPath);

        try (BufferedWriter bufferWriter = Files.newBufferedWriter(Paths.get(currentPath), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            bufferWriter.write("hakuna matata, no worries");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
