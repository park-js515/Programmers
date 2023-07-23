import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), D = Integer.parseInt(input[1]);
        int[] DP = new int[D + 1];

        for (int i=0;i<D+1;i++) {
            DP[i] = i;
        }

        ArrayList<int[]> lst = new ArrayList<>();
        for (int i=0;i<N;i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);

            if (end - start > dist && end <= D) {
                lst.add(new int[] { start, end, dist });
            }
        }

        for (int[] now: lst) {
            int start = now[0];
            int end = now[1];
            int dist = now[2];
            if (0 == start && DP[end] > DP[0]+dist) {
                DP[end] = DP[0]+dist;
            }
        }

        for (int i=1;i<D+1;i++) {
            DP[i] = Math.min(DP[i], DP[i-1] + 1);

            for (int[] now: lst) {
                int start = now[0];
                int end = now[1];
                int dist = now[2];
                if (i == start && DP[end] > DP[start]+dist) {
                    DP[end] = DP[start]+dist;
                }
            }
        }

        bw.write(DP[D]+"");
        br.close();
        bw.close();
    }
}
