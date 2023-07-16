import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        int N = pint(br.readLine());
        int target = pint(br.readLine());

        for (int i = 1; i < N; i++) {
            pq.add(pint(br.readLine()));
        }

        int cnt = 0;

        if (N == 1) {
            System.out.println(cnt);
        }
        else {
            while (target <= pq.peek()) {
                int temp = pq.poll();
                pq.add(temp - 1);
                target++;
                cnt++;
            }

            System.out.println(cnt);
        }
        br.close();
    }
}