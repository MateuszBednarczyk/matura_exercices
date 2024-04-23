import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        List<String> results = new ArrayList<>();

        for (String s : data) {
            if (s.charAt(0) == ']') {
                results.add("nie");
                continue;
            } else if (s.charAt(s.length() - 1) == '[') {
                results.add("nie");
                continue;
            } else {
                int otwarcia = 0;
                int zamkniecia = 0;

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '[') {
                        otwarcia++;
                    } else {
                        zamkniecia++;
                    }
                }

                if (otwarcia == zamkniecia) {
                    results.add("tak");
                } else {
                    results.add("nie");
                }
            }
        }
        System.out.println(results);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane2_4.txt").toURI()));
    }
}