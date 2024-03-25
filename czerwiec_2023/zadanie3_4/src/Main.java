import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFile("anagram.txt");

        int countOfValuesWithoutZero = 0;

        for (String n : lines) {
            if (!hasZero(convertToDec(n))) {
                countOfValuesWithoutZero++;
            }
        }

        int biggestSum = 0;
        String biggestVal = "";
        for (String n : lines) {
            String valueConvertedToDec = String.valueOf(convertToDec(n));
            List<String> alreadySummedValues = new ArrayList<>();
            int actualSum = 0;
            for (String c : valueConvertedToDec.split("")) {
                if (!alreadySummedValues.contains(c)) {
                    alreadySummedValues.add(c);
                    actualSum = actualSum + Integer.parseInt(c);
                }
            }

            if (actualSum > biggestSum) {
                biggestSum = actualSum;
                biggestVal = valueConvertedToDec;
            }
        }

        System.out.println(countOfValuesWithoutZero);
        System.out.println(biggestVal);
    }

    public static boolean hasZero(int n) {
        return String.valueOf(n).contains("0");
    }

    public static int convertToDec(String number) {
        return Integer.parseInt(number, 2);
    }
}

class FileReader {
    public List<String> readFile(String path) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource(path).toURI()));
    }
}