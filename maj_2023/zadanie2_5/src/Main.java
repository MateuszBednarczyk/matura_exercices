import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> data = readFiles();
        for (String d : data) {
            System.out.println(makeOperation(d));
        }
    }

    public static List<String> readFiles() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/maturka_informatyka/zadanie2_5/src/bin.txt"));
    }

    public static String makeOperation(String p) {
        String result = "";
        String halfOfP = divideBy2(p);

        if (p.length() > halfOfP.length()) {
            for (int i = 0; i < p.length() - halfOfP.length(); i++) {
                halfOfP = "0" + halfOfP;
            }
        } else if (halfOfP.length() > p.length()) {
            for (int i = 0; i < halfOfP.length() - p.length(); i++) {
                p = "0" + p;
            }
        }

        for (int i = p.length()-1; i >= 0; i--){
            if (p.charAt(i) == halfOfP.charAt(i)) {
                result = "0" + result;
            } else {
                result = "1" + result;
            }
        }

        return result;
    }

    public static String divideBy2(String p) {
        return Integer.toBinaryString(Integer.parseInt(p, 2) / 2);
    }
}