public class Main {
    public static void main(String[] args) {
        System.out.println(liczBloki(konwertujNaBinarny(67)));
    }

    public static String konwertujNaBinarny(int n) {
        String wynik = "";
        while (n > 0) {
            if (n % 2 == 0) {
                wynik = '0' + wynik;
            } else {
                wynik = '1' + wynik;
            }
            n = n / 2;
        }
        return wynik;
    }

    public static int liczBloki(String n) {
        int bloki = 1;
        for (int i = 0; i < n.length()-1; i++) {
            if (n.charAt(i+1) != n.charAt(i)) {
                bloki++;
            }
        }
        return bloki;
    }
}