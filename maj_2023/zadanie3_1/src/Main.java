import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        openFile().forEach(x -> {
            numbers.add(Integer.valueOf(x));
        });

        int r = 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
            if(Integer.parseInt(String.valueOf(numbers.get(i)) + String.valueOf(numbers.get(i+1))) > 90) {
                r++;
            }
        }

        System.out.println(r);
    }

    public static List<String> openFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/matura_exercices/zalaczniki_maj_2023/pi_przyklad.txt"));
    }
}