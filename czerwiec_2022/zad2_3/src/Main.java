public class Main {
    public static void main(String[] args) {
        String s1 = koduj(777777);
        String s2 = koduj(777776);

        System.out.println(s1);
        System.out.println(s2);
    }

    public static String koduj(int n) {
        if (n == 1) {
            return "";
        }

        int k = n / 2;
        if (k % 2 == 0) {
            return koduj(k) + "A";
        } else {
            return "B" + koduj(k);
        }
    }
}

//jeżeli n = 1
//wynikiem jest ''
//w przeciwnym wypadku
//k = n div 2
//jeżeli k mod 2 = 0
//wynikiem jest Koduj(k) + 'A'
//w przeciwnym wypadku
//wynikiem jest 'B' + Koduj(k)