import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String[] alfabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "W", "X", "Y", "Z"};

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        StringBuilder napis = new StringBuilder();

        for (String i : data) {
            String instrukcja = Arrays.stream(i.split(" ")).toList().get(0);
            String litera = Arrays.stream(i.split(" ")).toList().get(1);

            switch (instrukcja) {
                case "DOPISZ":
                    napis = dopisz(napis, litera);
                    break;
                case "ZMIEN":
                    napis = zmien(napis, litera);
                    break;
                case "USUN":
                    napis = usun(napis);
                    break;
                case "PRZESUN":
                    napis = przesun(napis, litera);
                    break;
            }
        }

        System.out.println(napis.toString().length());
        System.out.println(napis);
    }

    public static StringBuilder dopisz(StringBuilder s, String litera) {
        s.append(litera);
        return s;
    }

    public static StringBuilder zmien(StringBuilder s, String litera) {
        s.deleteCharAt(s.length() - 1);
        s.append(litera);
        return s;
    }

    public static StringBuilder usun(StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
        return s;
    }

    public static StringBuilder przesun(StringBuilder s, String litera) {
        if (s.toString().contains(litera)) {
            int indexLiterkiDoZmianyWyraz = s.indexOf(litera);
            int indexLiterkiDoZmianyAlfabet = Arrays.stream(alfabet).toList().indexOf(litera);
            if (indexLiterkiDoZmianyAlfabet == alfabet.length - 1) {
                s.setCharAt(indexLiterkiDoZmianyWyraz, alfabet[0].charAt(0));
            } else {
                s.setCharAt(indexLiterkiDoZmianyWyraz, alfabet[indexLiterkiDoZmianyAlfabet + 1].charAt(0));
            }
        } else {

        }

        return s;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("instrukcje.txt").toURI()));
    }
}