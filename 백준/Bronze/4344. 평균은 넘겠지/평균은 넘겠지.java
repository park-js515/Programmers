import java.util.*;
import java.io.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int C = pint(br.readLine());

        for (int c = 0; c < C; c++) {
            input = br.readLine().split(" ");
            int N = pint(input[0]);
            int[] arr = new int[N];
            double sum = 0;

            for (int i = 1; i <= N; i++) {
                arr[i - 1] = pint(input[i]);
                sum += arr[i - 1];
            }

            double avg = sum / N;
            double cnt = 0;
            for (int i = 0; i < N; i++) {
                if (avg < arr[i]) {
                    cnt++;
                }
            }

            System.out.printf("%.3f%%\n", (cnt/N)*100);
        }

        br.close();
    }
}