public class Main {
    public static void main(String[] args) {
        int n = 400;
        System.out.println(Integer.toUnsignedString(n, 3));
        System.out.println(Integer.toUnsignedString(n, 9));

        System.out.println(Integer.parseUnsignedInt("101201", 3));
        System.out.println(Integer.toUnsignedString(Integer.parseUnsignedInt("101201", 3), 9));

        System.out.println(Integer.parseUnsignedInt("2487", 9));
        System.out.println(Integer.toUnsignedString(Integer.parseUnsignedInt("2487", 9), 3));
    }
}