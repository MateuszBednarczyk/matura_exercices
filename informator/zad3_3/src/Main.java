import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> dane = fileReader.readLines();

        int maxDlugosc = 0;
        for (int i = 1; i < dane.size(); i++) {
            int dlugoscLancucha = 0;
            List<String> poczatkiPrzedzialow = new ArrayList<>();
            List<String> koncowkiPrzedzialow = new ArrayList<>();
            while (czyPrzedzialNastepnyZawieraPoprzedni(dane.get(i), dane.get(i - 1))) {
                poczatkiPrzedzialow.add(dane.get(i).split(" ")[0]);
                koncowkiPrzedzialow.add(dane.get(i).split(" ")[1]);
                poczatkiPrzedzialow.add(dane.get(i - 1).split(" ")[0]);
                koncowkiPrzedzialow.add(dane.get(i - 1).split(" ")[1]);
                dlugoscLancucha++;
                i++;
            }

            if (dlugoscLancucha >= 1) {
                List<Integer> poczatkiKonwertowane = poczatkiPrzedzialow.stream().map(Integer::parseInt).toList();
                List<Integer> koncowkiKonwertowane = koncowkiPrzedzialow.stream().map(Integer::parseInt).toList();

                poczatkiKonwertowane = poczatkiKonwertowane.stream().sorted().toList();
                koncowkiKonwertowane = koncowkiKonwertowane.stream().sorted().toList();

                int a = poczatkiKonwertowane.get(0);
                int b = koncowkiKonwertowane.get(koncowkiKonwertowane.size() - 1);

                int dlugosc = b - a + 1;

                if (dlugosc > maxDlugosc) {
                    maxDlugosc = dlugosc;
                }
            }
        }

        System.out.println(maxDlugosc);
    }

    public static boolean czyPrzedzialNastepnyZawieraPoprzedni(String nastepny, String poprzedni) {
        int a1 = Integer.parseInt(nastepny.split(" ")[0]);
        int b1 = Integer.parseInt(nastepny.split(" ")[1]);
        int a2 = Integer.parseInt(poprzedni.split(" ")[0]);
        int b2 = Integer.parseInt(poprzedni.split(" ")[1]);

        return a2 >= a1 && a2 <= b1 && b2 >= a1 && b1 <= b2;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane3.txt").toURI()));
    }
}