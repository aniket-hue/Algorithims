import java.util.Arrays;

class Test {
    static int[] dp;

    static int dri(int[] a, int s, int n) {
        if (n == 0) {
            if (s % a[n] == 0) {
                System.out.println(a[n]);
                return 1;
            } else
                return 0;

        }
        if (dp[n] != -1)
            return dp[n];
        if (s % a[n] == 0) {
            System.out.println(a[n]);
            return dp[n] = dri(a, a[n], n - 1) + 1;

        } else
            return dp[n] = dri(a, s, n - 1);
    }

    static void dri_util(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println("asd");
            max = Math.max(max, dri(a, 0, i));

        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 9, 15, 27};

        dp = new int[a.length];
        Arrays.fill(dp, -1);
        Arrays.sort(a);
        dri_util(a);
    }
}
