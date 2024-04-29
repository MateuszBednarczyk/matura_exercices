public class Main {
    public static void main(String[] args) {
        System.out.println(reszta(5,7,2));
    }

    public static int reszta(int x, int m, int a) {
        int p = a;
        for (int i = 1; i < x; i++) {
            p*=a;
        }

        return p % m;
    }
}