public class Main {
    public static void main(String[] args) {
        int i1 = Integer.parseInt("3211", 4);
        int i2 = Integer.parseInt("2322", 4);
        String sumI1I2In4 = Integer.toString(i1+i2, 4);
        System.out.println(sumI1I2In4);

        String sumI1I2In16 = Integer.toString(i1+i2, 16);
        System.out.println(sumI1I2In16);

        String diffI1I2In4 = Integer.toString(i1-i2, 4);
        System.out.println(diffI1I2In4);

        String diffI1I2In16 = Integer.toString(i1-i2, 16);
        System.out.println(diffI1I2In16);
    }
}