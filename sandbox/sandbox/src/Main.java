public class Main {
    public static void main(String[] args) {
        String i1 = "101101";
        String i2 = "111011";

        Integer r1 = Integer.parseInt(i1, 2) + Integer.parseInt(i2, 2);
        System.out.println(Integer.toBinaryString(r1));
        System.out.println(Integer.toHexString(r1));
        System.out.println(Integer.toOctalString(r1));
        System.out.println(Integer.toUnsignedString(r1, 4));
    }
}