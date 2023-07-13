import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = pint(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        long[] prefixed_sum = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = pint(input[i]);
        }

        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp += arr[i];
            temp %= 1_000_000_007;
            prefixed_sum[i] = temp;
        }

        long sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += (long)arr[i] * (prefixed_sum[N - 1] - prefixed_sum[i]);
            sum %= 1_000_000_007;
        }

        System.out.println(sum);
        br.close();
    }
}