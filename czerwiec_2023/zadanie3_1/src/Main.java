import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> lines = readFile();
        System.out.println(lines);

        int liczbyZrownowazone = 0;
        int liczbyPrawieZrownowazone = 0;

        for (String l : lines) {
            int liczbaZer = 0;
            int liczbaJedynek = 0;
            for (char c : l.toCharArray()) {
                if (c == 48) {
                    liczbaZer++;
                } else {
                    liczbaJedynek++;
                }
            }

            if (liczbaZer == liczbaJedynek) {
                liczbyZrownowazone++;
            } else if (liczbaJedynek == liczbaZer + 1 || liczbaJedynek == liczbaZer - 1) {
                liczbyPrawieZrownowazone++;
            }
        }

        System.out.println(liczbyZrownowazone);
        System.out.println(liczbyPrawieZrownowazone);
    }

    public static List<String> readFile() throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        return fileReader.ReadFile();
    }
}