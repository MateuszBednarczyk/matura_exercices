import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileLines = openFile();
        List<String> numericalSequences = new ArrayList<>();
        List<String> meetingRequirementsSequences = new ArrayList<>();

        for (int i = 0; i < fileLines.size() - 6; i++) {
            StringBuilder sequence = new StringBuilder();
            sequence.append(fileLines.get(i)).append(fileLines.get(i + 1)).append(fileLines.get(i + 2)).append(fileLines.get(i + 3)).append(fileLines.get(i + 4)).append(fileLines.get(i + 5));

            numericalSequences.add(sequence.toString());
        }

        for (String sequence : numericalSequences) {
            String[] chars = sequence.split("");

            if (isSequenceAscending(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]), Integer.parseInt(chars[2]))
                    && isSequenceDescending(Integer.parseInt(chars[3]), Integer.parseInt(chars[4]), Integer.parseInt(chars[5]))) {
                meetingRequirementsSequences.add(sequence);
            }
        }

        System.out.println(meetingRequirementsSequences);
    }

    public static List<String> openFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/matura_exercices/zalaczniki_maj_2023/pi_przyklad.txt"));
    }

    public static boolean isSequenceAscending(Integer c1, Integer c2, Integer c3) {
        return c1 <= c2 && c2 <= c3;
    }

    public static boolean isSequenceDescending(Integer c4, Integer c5, Integer c6) {
        return c4 >= c5 && c5 >= c6;
    }
}