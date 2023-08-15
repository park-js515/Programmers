import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = pint(br.readLine());
        for (int k = 0; k < K; k++) {
            String[] input = br.readLine().split(" ");
            int N = pint(input[0]);
            int[] arr = new int[N];

            for (int i = 1; i <= N; i++) {
                int temp = pint(input[i]);
                arr[i - 1] = temp;
            }

            Arrays.sort(arr);

            int Max = arr[N - 1];
            int Min = arr[0];
            int Gap = 0;

            for (int i = 0; i < N - 1; i++) {
                Gap = Math.max(Gap, arr[i + 1] - arr[i]);
            }

            bw.write("Class " + (k + 1) + "\n");
            bw.write("Max " + Max + ", Min " + Min + ", Largest gap " + Gap + "\n");
        }
        bw.close();
        br.close();
    }
}