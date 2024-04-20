public class Main {
    public static void main(String[] args) {
        String s1 = "132";
        String s2 = "3111";

        int i = Integer.parseInt(s1, 4) + Integer.parseInt(s2, 4);

        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toOctalString(i));
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toUnsignedString(i, 4));
    }
}