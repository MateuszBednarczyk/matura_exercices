import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> numbersFromFile = openFile();
        List<Integer> convertedNumbers = new ArrayList<>();
        HashMap<Integer, Integer> r = new HashMap<>();

        for (int i = 0; i < numbersFromFile.size() - 1; i++) {
            convertedNumbers.add(Integer.parseInt(numbersFromFile.get(i) + numbersFromFile.get(i + 1)));
        }

        for (Integer n : convertedNumbers) {
            if (!r.containsKey(n)) {
                r.put(n, 1);
            } else {
                r.replace(n, r.get(n), r.get(n) + 1);
            }
        }

        int maxFreq = -1;
        int maxVal = -1;

        int minFreq = numbersFromFile.size();
        int minVal = -1;

        for (Integer n : r.keySet()) {
            int actualFreq = r.get(n);

            if (actualFreq < minFreq) {
                minFreq = actualFreq;
                minVal = n;
            } else if (actualFreq > maxFreq) {
                maxFreq = actualFreq;
                maxVal = n;
            }
        }

        System.out.println(r);

        System.out.println(minVal + " " + minFreq);
        System.out.println(maxVal + " " + maxFreq);
    }

    public static List<String> openFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/matura_exercices/zalaczniki_maj_2023/pi.txt"));
    }
}