import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> rawData = fileReader.readLines();
        List<Integer> data = rawData.stream().map(Integer::parseInt).toList();

        for (Integer i : data) {
            StringBuilder converted = new StringBuilder(String.valueOf(i));
            String reversed = converted.reverse().toString();

            int reversedInt = Integer.parseInt(reversed);

            if (reversedInt % 17 == 0) {
                System.out.println(reversedInt);
            }
        }
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}