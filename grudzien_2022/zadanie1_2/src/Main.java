import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> processedData = List.of(fileReader.readLines().get(0).split(""));

        int pointsOfTeamA = 0, pointsOfTeamB = 0;
        for (int i = 0; i < processedData.size(); i++) {
            if (processedData.get(i).charAt(0) == 'A') {
                pointsOfTeamA++;
            } else {
                pointsOfTeamB++;
            }

            if (pointsOfTeamA >= 1000 && pointsOfTeamA - pointsOfTeamB >= 3) {
                break;
            } else if (pointsOfTeamB >= 1000 && pointsOfTeamB - pointsOfTeamA >= 3) {
                break;
            }
        }

        if (pointsOfTeamA > pointsOfTeamB) {
            System.out.printf("A %d:%d", pointsOfTeamA, pointsOfTeamB);
        } else {
            System.out.printf("B %d:%d", pointsOfTeamA, pointsOfTeamB);
        }
    }
}

class FileReader {
    public FileReader() {
    }

    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("mecz.txt").toURI()));
    }
}