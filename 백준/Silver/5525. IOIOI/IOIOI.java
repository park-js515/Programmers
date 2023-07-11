import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = pint(br.readLine());
        int M = pint(br.readLine());
        String S = br.readLine();
        int[] arr = new int[M];

        for (int i = 2; i < M; i++) {
            if (S.charAt(i) == 'I' && S.charAt(i - 2) == 'I' && S.charAt(i - 1) == 'O') {
                arr[i] = arr[i - 2] + 1;
            }
        }

        int cnt = 0;
        for (int i: arr) {
            if (i >= N) {
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}