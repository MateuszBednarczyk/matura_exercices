public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("2011", 3) == Integer.parseInt("134", 6));
        System.out.println(Integer.parseInt("134", 5) < Integer.parseInt("134", 6));
        System.out.println(Integer.parseInt("2222", 3) < Integer.parseInt("1111", 6));
    }
}