import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> dane = fileReader.readLines();

        int planszePusteKolumny = 0;
        int maxLiczbaPustychKolumn = 0;
        for (int i = 0; i < dane.size(); i++) {
            List<String> symulacja = new ArrayList<>(List.of(".", ".", ".", ".", ".", ".", ".", "."));
            List<String> plansza = new ArrayList<>();
            while (i < dane.size() && !isLineEmpty(dane.get(i))) {
                plansza.add(dane.get(i));
                i++;
            }

            for (String wiersz : plansza) {
                for (int j = 0; j < wiersz.length(); j++) {
                    if (wiersz.charAt(j) != '.') {
                        symulacja.set(j,"X");
                    }
                }
            }

            if (symulacja.toString().contains(".")) {
                planszePusteKolumny++;
                long liczbaPustychKolumn = symulacja.stream().filter(x -> Objects.equals(x, ".")).count();
                if (liczbaPustychKolumn > maxLiczbaPustychKolumn) {
                    maxLiczbaPustychKolumn = (int) liczbaPustychKolumn;
                }
            }
        }

        System.out.println(planszePusteKolumny + " " + maxLiczbaPustychKolumn);
    }

    public static boolean isLineEmpty(String l) {
        return l.length() == 0;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("szachy.txt").toURI()));
    }
}