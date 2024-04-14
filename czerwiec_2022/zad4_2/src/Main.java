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

        int number = 0;
        int biggestDiff = 0;
        for (Integer i : data) {
            StringBuilder reversedIString = new StringBuilder(String.valueOf(i));
            Integer reversed = Integer.valueOf(reversedIString.reverse().toString());

            Integer difference = Math.abs(i - reversed);
            if (difference > biggestDiff) {
                number = i;
                biggestDiff = difference;
            }
        }

        System.out.println(number + " " + biggestDiff);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}