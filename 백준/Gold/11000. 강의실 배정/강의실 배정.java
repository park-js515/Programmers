import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = pint(br.readLine());
        int[][] arr = new int[N][2];


        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            arr[i][0] = pint(input[0]);
            arr[i][1] = pint(input[1]);

        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0])
                .thenComparingInt((int[] o) -> o[1]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            int S = arr[i][0];
            int T = arr[i][1];

            int nowTime = queue.peek();

            if (nowTime <= S) {
                queue.poll();
            }
            else {
                cnt++;
            }

            queue.add(T);
        }

        System.out.println(cnt);
        br.close();
    }
}