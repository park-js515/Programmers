import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        int N = pint(br.readLine());
        int[] prefixed = new int[N + 1];
        input = br.readLine().split(" ");

        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += pint(input[i]);
            prefixed[i + 1] = temp;
        }

        int M = pint(br.readLine());
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            bw.write(prefixed[pint(input[1])] - prefixed[pint(input[0]) -1] + "\n");
        }
        br.close();
        bw.close();
    }
}