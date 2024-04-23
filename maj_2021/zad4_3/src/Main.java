import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        HashMap<String, Integer> literyWystepowania = new HashMap<>();

        for (String i : data) {
            String instrukcja = i.split(" ")[0];
            String litera = i.split(" ")[1];
            if (Objects.equals(instrukcja, "DOPISZ")) {
                if (!literyWystepowania.containsKey(litera)) {
                    literyWystepowania.put(litera, 1);
                } else {
                    int aktualnaWartosc = literyWystepowania.get(litera);
                    literyWystepowania.replace(litera, aktualnaWartosc, aktualnaWartosc + 1);
                }
            }
        }

        String max = "";
        int maxCount = 0;
        Set<String> litery = literyWystepowania.keySet();
        for (int i = 0; i < litery.size(); i++) {
            if (literyWystepowania.get(litery.toArray()[i]) > maxCount) {
                maxCount = literyWystepowania.get(litery.toArray()[i]);
                max = String.valueOf(litery.toArray()[i]);
            }
        }

        System.out.println(max);
        System.out.println(maxCount);

    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("instrukcje.txt").toURI()));
    }
}