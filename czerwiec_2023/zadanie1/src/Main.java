public class Main {

    static int liczbaDodawan = 0;

    public static void main(String[] args) {
        System.out.println(iloczyn(112, 112));
        System.out.println(liczbaDodawan);
    }

    public static int iloczyn(int x, int y) {
        if (y == 1) {
            return x;
        } else {
            int k = y / 2;
            int z = iloczyn(x, k);
            if (y % 2 == 0) {
                System.out.printf("wynik dla x %d, y %d, k %d to %d \n", x, y, k, z + z);
                liczbaDodawan = liczbaDodawan + 1;

                return z + z;
            } else {
                System.out.printf("wynik dla x %d, y %d, k %d to %d \n ", x, y, k, x + z + z);
                liczbaDodawan = liczbaDodawan + 2;

                return x + z + z;
            }
        }
    }
}