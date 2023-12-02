import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> data = readFile();
        int biggest = 0;
        String biggestAsBinary = "";
        for (String n : data) {
            int actual = Integer.parseInt(n, 2);
            if (actual > biggest) {
                biggest = actual;
                biggestAsBinary = n;
            }
        }

        System.out.println(biggestAsBinary);
        System.out.println(biggest);

        //1110100011100011100
    }

    public static List<String> readFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/maturka_informatyka/zadanie2_3/src/bin.txt"));
    }
}