import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.ReadFile();
        List<String> anagrams = new ArrayList<>();

        for (String s : lines) {
            int l = s.length();
            if (l == 8 && countRequiredStringExistance(s) > 3 && countRequiredStringExistance(s) < 6) {
                anagrams.add(s);
            }
        }

        System.out.println(anagrams);
        System.out.println(anagrams.size());
    }

    public static int countRequiredStringExistance(String s) {
        int r = 0;
        for (String c : s.split("")) {
            if (c.equals("1")) {
                r++;
            }
        }

        return r;
    }
}

class FileReader {
    public List<String> ReadFile() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("przyklad.txt").toURI()));
    }
}