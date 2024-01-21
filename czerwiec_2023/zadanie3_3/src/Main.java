import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fR = new FileReader();
        List<String> lines = fR.readLines();

        for (int i = 0; i < lines.size(); i++) {

        }
    }
}

class FileReader {
    public List<String> readLines() throws IOException {
        return Files.readAllLines(Paths.get(String.valueOf(getClass().getResource("przyklad.txt"))));
    }
}