import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> rawData = readLines();
        List<String> processedData = List.of(rawData.get(0).split(""));
        int result = 0;

        for (int i = 1; i < processedData.size(); i++) {
            if (processedData.get(i).charAt(0) != processedData.get(i - 1).charAt(0)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static List<String> readLines() throws IOException, URISyntaxException {
        FileReader fileReader = new FileReader();
        return fileReader.readFileLines();
    }
}

class FileReader {
    public FileReader() {
    }

    public List<String> readFileLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("mecz.txt").toURI()));
    }
}