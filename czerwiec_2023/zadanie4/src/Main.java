public class Main {
    public static void main(String[] args) {
        int i1 = Integer.parseInt("101201", 3);
        System.out.println(Integer.toString(i1, 9));

        int i2 = Integer.parseInt("2487", 9);
        System.out.println(Integer.toString(i2, 3));
    }
}