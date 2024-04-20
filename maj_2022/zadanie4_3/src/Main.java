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
        List<List<Integer>> listyTrojek = new ArrayList<>();
        List<List<Integer>> listaPiatek = new ArrayList<>();

        List<List<Integer>> dobreTrojki = new ArrayList<>();
        List<List<Integer>> dobrePiatki = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            int x = data.get(i);
            for (int j = i + 1; j < data.size(); j++) {
                int y = data.get(j);
                for (int k = j + 1; k < data.size(); k++) {
                    int z = data.get(k);
                    listyTrojek.add(List.of(x, y, z));
                }
            }
        }

        for (List<Integer> lista : listyTrojek) {
            int x = lista.get(0);
            int y = lista.get(1);
            int z = lista.get(2);

            if (czyDobraTrojka(x, y, z)) {
                dobreTrojki.add(lista);
            }
        }

//        for (int i = 0; i < data.size(); i++) {
//            int u = data.get(i);
//            for (int j = i + 1; j < data.size(); j++) {
//                int w = data.get(j);
//                for (int k = j + 1; k < data.size(); k++) {
//                    int x = data.get(k);
//                    for (int l = k + 1; l < data.size(); l++) {
//                        int y = data.get(l);
//                        for (int m = l + 1; m < data.size(); m++) {
//                            int z = data.get(m);
//                            listaPiatek.add(List.of(u, w, x, y, z));
//                        }
//                    }
//                }
//            }
//        }
//
//        for (List<Integer> lista : listaPiatek) {
//            int u = lista.get(0);
//            int w = lista.get(1);
//            int x = lista.get(3);
//            int y = lista.get(4);
//            int z = lista.get(5);
//
//            if (czyDobraPiatka(u, w, x, y, z)) {
//                dobrePiatki.add(lista);
//            }
//        }

        System.out.println(dobreTrojki);
//        System.out.println(dobrePiatki);

    }

    public static boolean czyDobraTrojka(int x, int y, int z) {
        return y % x == 0 && z % y == 0;
    }

    public static boolean czyDobraPiatka(int u, int w, int x, int y, int z) {
        return w % u == 0 && x % w == 0 && y % x == 0 && z % y == 0;
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("liczby.txt").toURI()));
    }
}