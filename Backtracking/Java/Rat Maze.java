import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Test {
    FastIO sc;
    static int n;
    static int[] dp;
    static int M = 1000000007;
    static int c = 0;
    static int[][] sol;

    static void f(int a[][], int x, int y, int n) {
        if (x == n - 1 && y == n - 1)
        {
            c++;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++)
                    System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }

        if (x >= n || y >= n || x < 0 || y < 0 || a[x][y] == 0 || sol[x][y] == 1)
            return;

        if (a[x][y] == 1) {

            sol[x][y] = 1;
            f(a, x + 1, y, n);
            f(a, x, y + 1, n);
            f(a, x - 1, y, n);
            f(a, x, y - 1, n);

            sol[x][y] = 0;
        }

    }

    void solve() throws Exception {
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        sol = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        f(a, 0, 0, n);
        System.out.println(c);
    }

    void run() {
        try {
            sc = new FastIO();
            solve();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignore) {
        }
        new Test().run();
    }

    class FastIO extends PrintWriter {
        private BufferedReader in;
        private StringTokenizer stok;

        FastIO() {
            super(System.out);
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        FastIO(String s) throws FileNotFoundException {
            super("".equals(s) ? "output.txt" : s + ".out");
            in = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : s + ".in"));
        }

        @Override
        public void close() {
            super.close();
            try {
                in.close();
            } catch (IOException ignored) {
            }
        }

        String next() {
            while (stok == null || !stok.hasMoreTokens()) {
                try {
                    stok = new StringTokenizer(in.readLine());
                } catch (Exception e) {
                    return null;
                }
            }
            return stok.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                return in.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        char[] nextCharArray() {
            return next().toCharArray();
        }
    }

    class Pair {
        int mon, fac;

        Pair(int mon, int fac) {
            this.mon = mon;
            this.fac = fac;
        }
    }

    class IntArray {
        private int capacity;
        private int[] data;
        private int size = 0;

        IntArray(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
        }

        IntArray() {
            this(16);
        }

        int get(int index) {
            return data[index];
        }

        void add(int x) {
            if (size == capacity) {
                int[] newData = new int[capacity * 2];
                System.arraycopy(data, 0, newData, 0, capacity);
                data = newData;
                capacity *= 2;
            }
            data[size++] = x;
        }

    }

    void randomShuffle(int[] a) {
        Random random = new Random();
        for (int i = 1; i < a.length; i++) {
            int x = random.nextInt(i + 1);
            int xchg = a[i];
            a[i] = a[x];
            a[x] = xchg;
        }
    }

    static boolean even(int n) {
        int r = n & 1;
        return r != 1 ? true : false;
    }
}
