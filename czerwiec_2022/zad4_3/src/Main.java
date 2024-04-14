import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<Integer> data = fileReader.readLines().stream().map(Integer::parseInt).toList();

        for (Integer i : data) {
            StringBuilder convertedInt = new StringBuilder(String.valueOf(i));

            if (isFirst(i) && isFirst(Integer.parseInt(convertedInt.reverse().toString()))) {
                System.out.println(i);
            }
        }
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