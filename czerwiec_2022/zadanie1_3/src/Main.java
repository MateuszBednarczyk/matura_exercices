public class Main {
    public static void main(String[] args) {
        int n = 82;
        boolean isBoring = false;
        int nSecure = n;

        while (n > 0 && !isBoring) {
            int suma = 0;
            while (n > 0) {
                suma += (n % 10) * (n % 10);
                n /= 10;
            }

            if (suma == 1) {
                isBoring = true;
            }

            n = suma;

            if (n == nSecure) {
                break;
            }
        }

        System.out.println(isBoring);
    }
}