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

        int n = 1000;
        int maxSuma = -100;
        for (int i = 0; i < n; i++) {
            int aktualnaSuma = 0;
            for (int j = n; j >= 1; j--) {
                if (j >= i) {
                    int sumaWycietego = 0;
                    List<Integer> sub = data.subList(i, j);
                    for (Integer k : sub) {
                        sumaWycietego += k;
                    }

                    if (sumaWycietego > aktualnaSuma) {
                        aktualnaSuma = sumaWycietego;
                    }
                }
            }

            if (aktualnaSuma > maxSuma) {
                maxSuma = aktualnaSuma;
            }
        }

        System.out.println(maxSuma);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane1_3.txt").toURI()));
    }
}

