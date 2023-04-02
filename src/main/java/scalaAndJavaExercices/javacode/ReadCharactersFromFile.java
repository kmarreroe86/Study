package scalaAndJavaExercices.javacode;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.
 * <p>
 * For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “”.
 */
public class ReadCharactersFromFile {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ReadCharactersFromFile obj = new ReadCharactersFromFile();
        obj.loadFileData();
    }

    public void loadFileData() throws IOException, URISyntaxException {
        Path path = Paths.get("src/resources/data_file.txt");
        int lengthTest = 3; /*7;*/
        int initialPos = 0;

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        processFile(data, initialPos, lengthTest);
    }

    private void processFile(String data, int currentPos, int length) {
        if (data.length() <= length) {
            System.out.println(data);
        } else {
            String str = data.substring(currentPos, currentPos + length);
            System.out.println(str);
            processFile(data.substring(currentPos + length), 0, length);
        }
    }

}

@FunctionalInterface
interface ReadString<S, P, I, S1> {
    S1 apply(S string, P position, I length);
}






















