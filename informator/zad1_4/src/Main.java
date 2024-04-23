import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> d = fileReader.readLines();
        List<Integer> data = d.stream().map(Integer::parseInt).collect(Collectors.toList());

        int n = 100000;
        int maxSuma = -100;
        int indexPierwszego = 0;
        int indexOstatniego = 0;
        for (int i = 0; i < n; i++) {
            int aktualnaSuma = 0;
            int roboczyIndexPierwszego = 0;
            int roboczyIndexOstatniego = 0;
            for (int j = n; j >= 1; j--) {
                if (j >= i) {
                    int sumaWycietego = 0;
                    List<Integer> sub = data.subList(i, j);
                    for (Integer k : sub) {
                        sumaWycietego += k;
                    }

                    if (sumaWycietego > aktualnaSuma) {
                        roboczyIndexPierwszego = i;
                        roboczyIndexOstatniego = j;
                        aktualnaSuma = sumaWycietego;
                    }
                }
            }

            if (aktualnaSuma > maxSuma) {
                indexPierwszego = roboczyIndexPierwszego;
                indexOstatniego = roboczyIndexOstatniego;
                maxSuma = aktualnaSuma;
            }
        }

        System.out.println(indexPierwszego + " " + indexOstatniego);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane1_4.txt").toURI()));
    }
}

