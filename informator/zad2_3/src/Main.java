import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> data = fileReader.readLines();
        int najwiekszaGlebokosc = 0;

        for (String aWyrazenie : data) {
            for (int j = 0; j < aWyrazenie.length(); j++) {
                int glebokosc = 0;
                if (aWyrazenie.charAt(j) == '[') {
                    while (aWyrazenie.charAt(j) == '[') {
                        j++;
                        glebokosc++;
                    }
                }

                if (glebokosc > najwiekszaGlebokosc) {
                    najwiekszaGlebokosc = glebokosc;
                }
            }
        }

        System.out.println(najwiekszaGlebokosc);
    }
}

class FileReader {
    public List<String> readLines() throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource("dane2_3.txt").toURI()));
    }
}