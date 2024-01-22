import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        FileReader fR = new FileReader();
        List<String> lines = fR.readLines();

        int biggestAbsoluteValue = 0;
        for (int i = 0; i < lines.size() - 1; i++) {
            int firstVal = convertToDec(lines.get(i));
            int secondVal = convertToDec(lines.get(i + 1));
            int r = Math.abs(firstVal - secondVal);
            if (r > biggestAbsoluteValue) biggestAbsoluteValue = r;
        }

        System.out.println(Integer.toBinaryString(biggestAbsoluteValue));
    }

    public static int convertToDec(String s) {
        return Integer.parseInt(s, 2);
    }
}

class FileReader {
    public List<String> readLines() throws IOException, URISyntaxException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("przyklad.txt").toURI()));
    }
}