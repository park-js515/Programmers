import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int x1 = 0, x2 = 0;
        for (boolean B: row) {
            if (!B) {
                x1++;
            }
        }
        for (boolean B: col) {
            if (!B) {
                x2++;
            }
        }

        System.out.println(Math.max(x1, x2));
        br.close();
    }
}