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
        List<String> instrukcje = new ArrayList<>();

        for (String i : data) {
            instrukcje.add(i.split(" ")[0]);
        }

        int aktualnyNajdluzszyCiagDlugosc = 0;
        String aktualnaInstrukcjaNajdluzszyCiag = "";

        for (int i = 0; i < instrukcje.size(); i++) {
            int wystapienia = 1;
            String instrukcja = instrukcje.get(i);
            for (int j = i + 1; j < instrukcje.size(); j++) {
                if (!instrukcje.get(j).equals(instrukcja)) {
                    break;
                } else {
                    wystapienia++;
                }
            }

            if (wystapienia > aktualnyNajdluzszyCiagDlugosc) {
                aktualnyNajdluzszyCiagDlugosc = wystapienia;
                aktualnaInstrukcjaNajdluzszyCiag = instrukcja;
            }
        }

        System.out.println(aktualnaInstrukcjaNajdluzszyCiag + " " + aktualnyNajdluzszyCiagDlugosc);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("instrukcje.txt").toURI()));
    }
}