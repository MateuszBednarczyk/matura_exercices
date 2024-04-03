import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//zadanie w obecnym stanie daje 1/3 punkty
public class Main {
    static int n = 100000;
    static List<String> data;
    static List<String> pary;

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        pary = new ArrayList<>();
        data = fileReader.readLines();
        rysuj(1);
        System.out.println(pary);
    }

    public static void rysuj(int x) {
        if (2 * x <= n) {
            strzalka(x, 2 * x);
            rysuj(2 * x);
        }
        if (2 * x + 1 <= n) {
            strzalka(x, 2 * x + 1);
            rysuj(2 * x + 1);
        }
    }

    public static void strzalka(int x, int y) {
        if (data.contains(x + " " + y)) {
            pary.add(x + " " + y);
        }
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("pary.txt").toURI()));
    }
}