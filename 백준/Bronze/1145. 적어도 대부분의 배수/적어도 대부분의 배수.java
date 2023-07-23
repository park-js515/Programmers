import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        int nowGcd = gcd(a, b);
        return a * b / nowGcd;
    }

    private static int ans = Integer.MAX_VALUE;

    private static void dfs(int[] arr, int depth, int start, int nowLcm) {
        if (ans <= nowLcm) {
            return;
        }

        if (depth == 3) {
            ans = nowLcm;
            return;
        }

        for (int i = start; i < 5; i++) {
            if (depth == 0) {
                dfs(arr, depth + 1, i + 1, arr[i]);
            }
            else {
                dfs(arr, depth + 1, i + 1, lcm(arr[i], nowLcm));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int[] arr = new int[5];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dfs(arr, 0, 0, 0);
        System.out.println(ans);
        br.close();
    }
}