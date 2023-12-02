import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int required = 0;
        for (String n : readFile()) {
            if (countBlocks(n) <= 2){
                required++;
            }
        }

        System.out.println(required);
    }

    public static List<String> readFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/maturka_informatyka/zadanie2_2/src/bin.txt"));
    }

    public static int countBlocks(String n) {
        int blocks = 1;
        for (int i = 0; i < n.length()-1; i++) {
            if (n.charAt(i+1) != n.charAt(i)) {
                blocks++;
            }
        }
        return blocks;
    }
}