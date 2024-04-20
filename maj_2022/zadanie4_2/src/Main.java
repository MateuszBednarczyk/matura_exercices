import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<Integer> data = fileReader.readLines().stream().map(Integer::parseInt).toList();

        List<List<Integer>> listyCzynnikow = new ArrayList<>();
        List<Integer> liczby = new ArrayList<>();

        int liczbaNajwiecejCzynnikow = 0;
        int szukana = 0;

        int liczbaNajwiecejRoznychCzynnikow = 0;
        int szukanaNajwiecejRoznychCzynnikow = 0;

        for (int i = 0; i < data.size(); i++) {
            List<Integer> czynniki = new ArrayList<>();
            int n = data.get(i);
            int nBackup = n;

            if (n == 1) {
                czynniki.add(1);
            } else {
                while (n != 1) {
                    int czynnik = znajdzCzynnik(n);
                    if (czynnik != 1 && isFirst(czynnik)) {
                        czynniki.add(czynnik);
                        n /= czynnik;
                    } else {
                        break;
                    }
                }
            }

            if (czynniki.size() > liczbaNajwiecejCzynnikow) {
                liczbaNajwiecejCzynnikow = czynniki.size();
                szukana = nBackup;
            }

            listyCzynnikow.add(czynniki);
            liczby.add(nBackup);
        }

        for (List<Integer> czynniki : listyCzynnikow) {
            List<Integer> subLista = new ArrayList<>();
            for (Integer czynnik : czynniki) {
                if (!subLista.contains(czynnik)) {
                    subLista.add(czynnik);
                }
            }

            if (subLista.size() > liczbaNajwiecejRoznychCzynnikow) {
                liczbaNajwiecejRoznychCzynnikow = subLista.size();
                szukanaNajwiecejRoznychCzynnikow = liczby.get(listyCzynnikow.indexOf(czynniki));
            }
        }

        System.out.println(szukana + " " + liczbaNajwiecejCzynnikow + " "
                + szukanaNajwiecejRoznychCzynnikow + " " + liczbaNajwiecejRoznychCzynnikow);
    }

    public static int znajdzCzynnik(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }

        return 1;
    }

    public static boolean isFirst(int n) {
        int dzielniki = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                dzielniki++;
            }
        }

        return dzielniki == 2;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}