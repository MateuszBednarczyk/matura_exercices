public class Main {
    static int strzalki = 0;
    static int n = 2047;

    public static void main(String[] args) {
        rysuj(1);
    }

    public static void rysuj(int x) {
        if (2 * x <= n) {
            strzalka(x, 2 * x);
            rysuj(2 * x);
        }
        if (2 * x + 1 <= n) {
            strzalka(x, 2 * x + 1);
            rysuj(2 * x + 1);
        }
    }

    public static void strzalka(int x, int y) {
        System.out.println(x + " " + y);
        if (n % y == 0 || n % y + 1 == 0) {
            strzalki++;
            if (y == n) {
                System.out.printf("aby dotrzec do n trzeba narysowac %d strzalek", strzalki);
            }
        }
    }
}