import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<Integer> data = fileReader.readLines().stream().map(Integer::parseInt).toList();

        List<Integer> detectedDifferentNumbers = new ArrayList<>();
        for (Integer i : data) {
            if (!detectedDifferentNumbers.contains(i)) {
                detectedDifferentNumbers.add(i);
            }
        }

        List<Integer> subListOfAlreadyCounted = new ArrayList<>();

        int existTwoTimes = 0;
        for (Integer i : data) {
            if (countExistance(i, data) == 2 && !subListOfAlreadyCounted.contains(i)) {
                subListOfAlreadyCounted.add(i);
                existTwoTimes++;
            }
        }

        subListOfAlreadyCounted.clear();

        int existThreeTimes = 0;
        for (Integer i : data) {
            if (countExistance(i, data) == 3 && !subListOfAlreadyCounted.contains(i)) {
                subListOfAlreadyCounted.add(i);
                existThreeTimes++;
            }
        }

        System.out.println(detectedDifferentNumbers.size());
        System.out.println(existTwoTimes);
        System.out.println(existThreeTimes);
    }

    public static int countExistance(int n, List<Integer> data) {
        int counter = 0;
        for (Integer i : data) {
            if (i == n) {
                counter++;
            }
        }

        return counter;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}