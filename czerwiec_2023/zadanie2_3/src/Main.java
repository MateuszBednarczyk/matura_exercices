import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "mascarpone";
        HashMap<Integer, String> sufixy = new HashMap<>();

        for (int i = 1; i <= s.length(); i++) {
            sufixy.put(i, createSufix(s, i, s.length()));
        }

        System.out.println(sufixy);

        List<String> sufs = new ArrayList<>();
        for (String suf : sufixy.values()) {
            sufs.add(suf);
        }

        sort(sufs, sufs.size());

        for (int i = 0; i < sufixy.size(); i++) {
            System.out.print((s.length() - sufs.get(i).length()) + 1 + ", ");
        }

        System.out.println(sufs);
    }

    public static void sort(List<String> arr, int n) {
        int i, j;
        String temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                int c = 0;
                while (arr.get(j).charAt(c) == arr.get(j + 1).charAt(c)) {
                    c++;
                }
                if (arr.get(j).charAt(c) > arr.get(j + 1).charAt(c)) {
                    temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, String.valueOf(temp));
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }
    }

    public static String createSufix(String s, int k, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = k; i <= n; i++) {
            stringBuilder.append(s.charAt(i - 1));
        }

        return stringBuilder.toString();
    }

    public static boolean czyMniejszy(int n, String s, int k1, int k2) {
        int i = k1;
        int j = k2;

        char[] chars = s.toCharArray();

        while (i <= n && j <= n) {
            if (chars[i] == chars[j]) {
                i++;
                j++;
            } else {
                if (chars[i] < chars[j]) {
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