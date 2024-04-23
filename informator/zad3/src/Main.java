import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> dane = fileReader.readLines();
        List<Integer> dlugosci = new ArrayList<>();

        for (String s : dane) {
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);

            int dlugosc = b - a + 1;
            dlugosci.add(dlugosc);
        }

        dlugosci = dlugosci.stream().sorted().toList();

        int najmniejsza = dlugosci.get(0);
        int drugaNajmniejsza = 0;
        for (int i = 1; i < dlugosci.size(); i++) {
            if (dlugosci.get(i) != najmniejsza) {
                drugaNajmniejsza = dlugosci.get(i);
                break;
            }
        }

        System.out.println(najmniejsza);
        System.out.println(drugaNajmniejsza);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane3.txt").toURI()));
    }
}