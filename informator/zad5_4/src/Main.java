public class Main {
    static int[] A = {1, 4, 3, 2};

    public static void main(String[] args) {
        proceduraW(3);
        for (Integer i : A) {
            System.out.println(i);
        }
    }

    public static void proceduraW(int j) {
        int i = j;
        while (i > 0) {
            while (A[j] < A[j - 1]) {
                int v = A[j];
                A[j] = A[j - 1];
                A[j - 1] = v;
                j--;
            }
            i--;
        }
    }
}