import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> fileLines = openFile();
        findLongestSequence(fileLines);
    }

    public static void findLongestSequence(List<String> data) {
        int lengthOfLongestSequenceWhichMeetRequirements = -1;

        String seq = "";

        for (int i = 0; i <= data.size() - 1; i++) {
            seq = "";
            seq = seq + data.get(i);
            for (int j = i+1; j < data.size() - 1; j++) {
                seq = seq + data.get(j);
                if (!isSequenceMeetingRequirements(seq)) {
                    seq = seq + data.get(j+1);
                    if (isSequenceMeetingRequirements(seq) && seq.length() > lengthOfLongestSequenceWhichMeetRequirements) {
                        continue;
                    }
                    break;
                } else if (isSequenceMeetingRequirements(seq) && seq.length() > lengthOfLongestSequenceWhichMeetRequirements) {
                    lengthOfLongestSequenceWhichMeetRequirements = seq.length();
                }
            }
        }

        System.out.println(lengthOfLongestSequenceWhichMeetRequirements);
    }

    public static boolean isSequenceMeetingRequirements(String sequence) {
        boolean meetingRequirements = false;
        int halfOfSequence = sequence.length() / 2;
        String[] seqArr = sequence.split("");
        for (int i = 0; i <= halfOfSequence - 1; i++) {
            meetingRequirements = isAsc(Integer.parseInt(seqArr[i]), Integer.parseInt(seqArr[i + 1]));
        }

        for (int j = halfOfSequence; j <= sequence.length() - 2; j++) {
            meetingRequirements = isDesc(Integer.parseInt(seqArr[j]), Integer.parseInt(seqArr[j + 1]));
        }

        return meetingRequirements;
    }

    public static boolean isAsc(Integer n1, Integer n2) {
        return n1 <= n2;
    }

    public static boolean isDesc(Integer n1, Integer n2) {
        return n1 >= n2;
    }

    public static List<String> openFile() throws IOException {
        return Files.readAllLines(Paths.get("/Users/mateuszbednarczyk/Desktop/matura_exercices/zalaczniki_maj_2023/pi_przyklad.txt"));
    }
}