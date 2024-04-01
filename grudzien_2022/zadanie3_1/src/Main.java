import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        int counter = 0;

        for (int i = 0; i < data.size(); i++) {
            int actualNumber = Integer.parseInt(data.get(i)) - 1;
            if (isFirst(actualNumber)) {
                counter++;
            }
        }

        System.out.printf("counter %d", counter);
    }

    public static boolean isFirst(int n) {
        int dividers = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                dividers++;
            }
        }

        return dividers == 2;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}