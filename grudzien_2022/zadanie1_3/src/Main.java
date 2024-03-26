import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//aktualny stan rozwiazania daje 2/3 punkty
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> processedData = List.of(fileReader.readLines().get(0).split(""));

        int longestPassa = 0;
        int passaCounter = 0;
        char actualPassaContestWinner = 0;

        for (int i = 0; i < processedData.size(); i++) {
            char actualWinner = processedData.get(i).charAt(0);
            int actualPassa = 0;

            for (int j = i; j < processedData.size(); j++) {
                char nextWinner = processedData.get(j).charAt(0);
                if (nextWinner == actualWinner) {
                    actualPassa++;
                } else {
                    i = j;
                    break;
                }
            }

            if (actualPassa > longestPassa && actualPassa >= 10) {
                actualPassa++;
                longestPassa = actualPassa;
                actualPassaContestWinner = actualWinner;
            }

            if (actualPassa > 10) {
                passaCounter++;
            }
        }

        System.out.printf("Najdluzsza dobra passe osiagnela druzyna %s", String.valueOf(actualPassaContestWinner));
        System.out.printf("\n passa miala dlugosc %d", longestPassa);
        System.out.printf("\n laczna ilosc dobrych pass to %d", passaCounter);
    }
}

class FileReader {
    public FileReader() {
    }

    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("mecz.txt").toURI()));
    }
}