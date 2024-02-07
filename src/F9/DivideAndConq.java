package F9;

public class DivideAndConq {
    public static int max(int[] a) {
        return max(a, 0, a.length - 1);
    }

    private static int max(int[] a, int low, int high) {
        if (low == high) return a[low];

        int mid = low + (high - low) / 2;

        int m1 = max(a, low, mid);
        int m2 = max(a, mid + 1, high);

        return Math.max(m1, m2);
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 23, 8, 9, 10};
        System.out.println(max(list));
    }
}
