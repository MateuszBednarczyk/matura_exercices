import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        System.out.println(data.size());

        HashMap<Integer, List<String>> r = new HashMap<>();
        int maxNum = Integer.valueOf(data.get(data.size() - 1));
        int maxN = 0;
        int maxSize = 0;
        int minN = maxNum;
        int minSize = maxNum;
        for (String n : data) {
            int sample = Integer.parseInt(n);
            List<String> results = new ArrayList<>();
            for (int i = 0; i <= sample; i++) {
                for (int j = 0; j <= sample; j++) {
                    if (i + j == sample && isFirst(i) && isFirst(j)) {
                        StringBuilder result = new StringBuilder();
                        if (i < j) {
                            result.append(i);
                            result.append(j);
                        } else {
                            result.append(j);
                            result.append(i);
                        }
                        if (!results.contains(result.toString())) {
                            results.add(result.toString());
                        }
                        System.out.printf("%d %d \n", i, j);
                    }
                }
            }
            if (!r.containsKey(sample)) {
                r.put(sample, results);
            }
        }
        for (Integer n : r.keySet()) {
            int actualSize = r.get(n).size();
            if (actualSize < minSize) {
                minN = n;
                minSize = actualSize;
            } else if (actualSize > maxSize) {
                maxN = n;
                maxSize = actualSize;
            }
        }
        System.out.printf("%d %d %d %d", maxN, maxSize, minN, minSize);
    }

    public static boolean isFirst(int n) {
        int dividers = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                dividers++;
            }
        }

        return dividers == 2;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby_przyklad.txt").toURI()));
    }
}