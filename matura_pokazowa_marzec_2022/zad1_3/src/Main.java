import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> dane = fileReader.readLines();

        int szachy = 0;

        for (int i = 0; i < dane.size(); i++) {
            List<String> plansza = new ArrayList<>();
            while (i < dane.size() && !dane.get(i).isEmpty()) {
                plansza.add(dane.get(i));
                i++;
            }

            StringBuilder symulacja = new StringBuilder("........");
            for (int j = 0; j < plansza.size(); j++) {
                String wiersz = plansza.get(j);
                int index = j;
                if (czyZawieraBialaWieze(wiersz) && czyZawieraCzarnegoKrola(wiersz)) {
                    int indexWieza = 0;
                    int indexKrol = 0;
                    for (int k = 0; k < wiersz.length(); k++) {
                        if (wiersz.charAt(k) == 'W') {
                            indexWieza = j;
                        } else if (wiersz.charAt(k) == 'k') {
                            indexKrol = j;
                        }
                    }

                    List<String> sub = Arrays.stream(wiersz.substring(indexKrol, indexWieza).split(".")).toList();
                    if (sub.size() == 0) {
                        szachy++;
                    }
                } else if (czyZawieraCzarnaWieze(wiersz) && czyZawieraBialegoKrola(wiersz)) {

                }
            }
        }

        System.out.println(szachy);
    }

    public static boolean czyZawieraBialaWieze(String w) {
        return w.contains("W");
    }

    public static boolean czyZawieraCzarnaWieze(String w) {
        return w.contains("w");
    }

    public static boolean czyZawieraBialegoKrola(String w) {
        return w.contains("K");
    }

    public static boolean czyZawieraCzarnegoKrola(String w) {
        return w.contains("k");
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("szachy_przyklad.txt").toURI()));
    }
}