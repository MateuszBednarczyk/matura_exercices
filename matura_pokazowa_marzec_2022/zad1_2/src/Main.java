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

        int liczbaPlanszRownowaga = 0;
        int najmniejszaLiczbaBierekNaPlanszyZeStanemRownowagi = 64;
        for (int i = 0; i < dane.size(); i++) {
            List<String> plansza = new ArrayList<>();
            while (i < dane.size() && !isLineEmpty(dane.get(i))) {
                plansza.add(dane.get(i));
                i++;
            }

            List<String> whitePieces = whitePieces(plansza);
            List<String> blackPieces = blackPieces(plansza);

            whitePieces = whitePieces.stream().sorted().toList();
            blackPieces = blackPieces.stream().sorted().map(String::toUpperCase).toList();

            if (whitePieces.equals(blackPieces)) {
                liczbaPlanszRownowaga++;
                if (whitePieces.size() < najmniejszaLiczbaBierekNaPlanszyZeStanemRownowagi) {
                    najmniejszaLiczbaBierekNaPlanszyZeStanemRownowagi = whitePieces.size() + blackPieces.size();
                }
            }
        }

        System.out.println(liczbaPlanszRownowaga + " " + najmniejszaLiczbaBierekNaPlanszyZeStanemRownowagi);
    }

    public static List<String> whitePieces(List<String> plansza) {
        List<String> result = new ArrayList<>();
        for (String s : plansza) {
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    result.add(String.valueOf(c));
                }
            }
        }

        return result;
    }

    public static List<String> blackPieces(List<String> plansza) {
        List<String> result = new ArrayList<>();
        for (String s : plansza) {
            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    result.add(String.valueOf(c));
                }
            }
        }

        return result;
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