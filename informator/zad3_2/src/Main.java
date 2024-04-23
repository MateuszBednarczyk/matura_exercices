import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
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

        HashMap<Integer, Integer> dlugosciIlosciWystapien = new HashMap<>();

        for (Integer d : dlugosci) {
            if (!dlugosciIlosciWystapien.containsKey(d)) {
                dlugosciIlosciWystapien.put(d, 1);
            } else {
                int aktualnaDlugosc = dlugosciIlosciWystapien.get(d);
                dlugosciIlosciWystapien.replace(d, aktualnaDlugosc, aktualnaDlugosc + 1);
            }
        }

        int najwiekszaLiczbaWystapienDanejDlugosci = dlugosciIlosciWystapien.values().stream().sorted().toList()
                .get(dlugosciIlosciWystapien.values().size() - 1);

        int najczesciejWystepujacaDlugosc = dlugosciIlosciWystapien.keySet().stream().toList().get
                (dlugosciIlosciWystapien.values().stream().toList().indexOf(najwiekszaLiczbaWystapienDanejDlugosci));

        System.out.println(najczesciejWystepujacaDlugosc);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane3.txt").toURI()));
    }
}