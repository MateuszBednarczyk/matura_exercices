import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        boolean[] numbers = new boolean[n];
        Arrays.fill(numbers, 2, n, true);

        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = i + i; j < n; j += i) {
                numbers[j] = false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]) {
                System.out.println(i);
            }
        }
    }
}