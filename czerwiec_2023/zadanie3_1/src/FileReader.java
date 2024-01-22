import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public List<String> ReadFile() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("anagram.txt").toURI()));
    }
}
