import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<String> dane =
                Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/matura_exercices/czerwiec_2023/DANE/DANE_M/slowa1.txt"));

        int n = Integer.parseInt(dane.get(0)) - 1;
        String[] k1k2 = dane.get(2).split(" ");
        int k1 = Integer.parseInt(k1k2[0]);
        int k2 = Integer.parseInt(k1k2[1]);

        System.out.println(n + "\n" + dane.get(1) + "\n" + k1 + "\n" + k2);

        System.out.println("result: " + czyMniejszy(n, dane.get(1), k1, k2));
    }

    public static boolean czyMniejszy(int n, String s, int k1, int k2) {
        int i = k1;
        int j = k2;

        while (i <= n && j <= n) {
            if (s.toCharArray()[i] == s.toCharArray()[j]) {
                i++;
                j++;
            } else {
                if (s.toCharArray()[i] < s.toCharArray()[j]) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (j <= n) {
            return true;
        } else {
            return false;
        }
    }
}