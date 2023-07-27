import java.util.*;
import java.io.*;

public class Main {
    private static int ftn(int N, int K) {
        boolean[] arr = new boolean[N + 1];

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                if (++cnt == K) {
                    return i;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        System.out.println(ftn(N, K));
        br.close();
    }
}