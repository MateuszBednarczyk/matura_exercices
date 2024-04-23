public class Main {
    public static void main(String[] args) {
        int[] A = {0, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1};

        w(7, A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
        System.out.println();

        w(9, A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + ",");
        }
        System.out.println();
    }

    public static void w(int j, int[] A) {
        if (j > 1) {
            if (A[j] < A[j - 1]) {
                int v = A[j];
                A[j] = A[j - 1];
                A[j - 1] = v;
                w(j - 1, A);
            }
        }
    }
}