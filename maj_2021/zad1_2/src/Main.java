public class Main {
    public static void main(String[] args) {
        int n = 9000;
        int d = 0;
        int mnoznik = 1;

        while (n != 0) {
            int r = n % 10;
            d = d + (9 - r) * mnoznik;
            mnoznik = mnoznik * 10;
            n /= 10;
        }

        System.out.println(d);
    }
}