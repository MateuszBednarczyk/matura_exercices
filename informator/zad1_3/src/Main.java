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
        System.out.println(data);
        int biggestSum = 0;

        for (int i = 0; i < data.size(); i++) {
            int aBiggestSum = 0;
            for (int j = i; j < data.size(); j++) {
                aBiggestSum += data.get(j);
                for (int k = data.size() - 1; k == j; k--) {
                    aBiggestSum += data.get(j);
                }
            }

            if (aBiggestSum > biggestSum) {
                biggestSum = aBiggestSum;
            }
        }

        System.out.println(biggestSum);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane1_3.txt").toURI()));
    }
}

