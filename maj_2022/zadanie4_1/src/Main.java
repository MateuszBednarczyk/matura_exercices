import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<Integer> data = fileReader.readLines().stream().map(Integer::parseInt).toList();
        String found = "";
        int nums = 0;

        for (Integer i : data) {
            if (String.valueOf(i).charAt(0) == String.valueOf(i).charAt(String.valueOf(i).length() - 1)) {
                nums++;
            }

            if (found == "") {
                found = String.valueOf(i);
            }
        }

        System.out.println(nums + " " + found);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}