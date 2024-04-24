import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// nie ogarniam 

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> dane = fileReader.readLines();

        for (String d : dane) {
            int minimalne = 0;
            for (int p = 2; p <= 10; p++) {
                if (czyZawieraMniejszaOJeden(d, p) && !czyZawieraWieksza(d, p)) {
                    minimalne++;
                }
                System.out.println(p + " " + minimalne);
            }
        }
    }

    public static boolean czyZawieraMniejszaOJeden(String s, int p) {
        for (String cyfra : s.split("")) {
            if (Integer.parseInt(cyfra) == p - 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean czyZawieraWieksza(String s, int p) {
        for (String cyfra : s.split("")) {
            if (Integer.parseInt(cyfra) > p - 1) {
                return true;
            }
        }

        return false;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane6przyklad.txt").toURI()));
    }
}