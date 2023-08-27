import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int MIN = 0;

        for (int i = 1; i <= 100; i++) {
            int val = i * i;
            if (val >= M && val <= N) {
                sum += val;

                if (MIN == 0) {
                    MIN = val;
                }
            }
        }

        if (sum > 0) {
            System.out.println(sum);
            System.out.println(MIN);
        }
        else {
            System.out.println(-1);
        }
        br.close();
        bw.close();
    }
}