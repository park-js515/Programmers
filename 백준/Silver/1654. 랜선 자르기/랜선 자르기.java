import java.util.*;
import java.io.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static int binarySearch(int max, int[] arr, int N) {
        long s = 1, e = max;

        while (s <= e) {
            long m =  (s + e) / 2;
            int n = 0;
            for (int a: arr) {
                n += a / m;
            }

            if (n < N) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return (int) e;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = pint(input[0]), N = pint(input[1]);
        int[] arr = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = pint(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch(max, arr, N));
        br.close();
    }
}