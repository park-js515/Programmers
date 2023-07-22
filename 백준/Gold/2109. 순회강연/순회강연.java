import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        // 우선순위 최하를 맨 위에 나둔다.
        int n = pint(br.readLine());
        int[][] arr = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            arr[i][0] = pint(input[0]);
            arr[i][1] = pint(input[1]);
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[1]));

        int time = 1;
        for (int i = 0; i < n; i++) {
            int p = arr[i][0];
            int d = arr[i][1];

            if (d > time) { // 그냥 추가
                time++;
                pq.add(p);
            }
            else { // 교체
                int top = pq.peek();

                if (top < p) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        int SUM = 0;
        for (int item: pq) {
            SUM += item;
        }

        System.out.println(SUM);
        br.close();
    }
}
