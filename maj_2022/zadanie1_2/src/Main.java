public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {5, 4, 1, 5, 6, 8};
        //trzeba podmienic 2 elementy
        int ile = 0;
        ile += liczWiekszeOdN(n, arr);
        ile += liczDuplikaty(arr, n);

        System.out.println(ile);
    }

    private static int liczWiekszeOdN(int n, int[] arr) {
        int ile = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > n) {
                ile++;
            }
        }
        return ile;
    }

    private static int liczDuplikaty(int[] arr, int n) {
        int l = 0;
        int[] sub = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < n) {
                sub[arr[i]] += 1;
            }
        }

        for (int i = 0; i < sub.length; i++) {
            if (sub[i] > 1) {
                l += sub[i] - 1;
            }
        }

        return l;
    }
}