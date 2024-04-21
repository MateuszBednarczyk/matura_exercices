public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt("333", 8);
        int l = Integer.parseInt("10100101", 2);
        System.out.println(isBigger(n, l));
    }

    public static boolean isBigger(int n, int l) {
        return n > l;
    }
}