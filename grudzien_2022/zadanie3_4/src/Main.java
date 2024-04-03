import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        StringBuilder result = new StringBuilder();
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0,
                six = 0, seven = 0, eight = 0, nine = 0;

        for (int i = 0; i < data.size(); i++) {
            String hex = Integer.toHexString(Integer.parseInt(data.get(i)));
            result.append(hex);
        }

        for (String s : result.toString().split("")) {
            switch (s) {
                case "a":
                    a++;
                    continue;
                case "b":
                    b++;
                    continue;
                case "c":
                    c++;
                    continue;
                case "d":
                    d++;
                    continue;
                case "e":
                    e++;
                    continue;
                case "f":
                    f++;
                    continue;
                case "1":
                    one++;
                    continue;
                case "2":
                    two++;
                    continue;
                case "3":
                    three++;
                    continue;
                case "4":
                    four++;
                    continue;
                case "5":
                    five++;
                    continue;
                case "6":
                    six++;
                    continue;
                case "7":
                    seven++;
                    continue;
                case "8":
                    eight++;
                    continue;
                case "9":
                    nine++;
                    continue;
                case "0":
                    zero++;
            }
        }

        System.out.printf("A:%d B:%d C:%d D:%d, E:%d, F:%d, 1:%d, 2:%d, 3:%d, 4:%d, 5:%d, 6:%d, 7:%d, 8:%d, 9:%d, 0:%d",
                a, b, c, d, e, f, one, two, three, four, five, six, seven, eight, nine, zero);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}