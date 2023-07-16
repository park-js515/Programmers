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

        pq.add(0);
        int cnt = 0;

        if (N == 1) {
            System.out.println(cnt);
        }
        else {
            breakPoint: while (target <= pq.peek()) {
                int temp = pq.poll();
                int gap = temp - pq.peek();

                if (gap > 0) {
                    if (pq.peek() == 0) {
                        cnt += (temp - target) / 2 + 1;
                        break breakPoint;
                    }
                    else {
                        if (target + gap > pq.peek()) {
                            for (int i = 0; i < gap; i++) {
                                target++;
                                cnt++;
                                temp--;

                                if (target > temp) {
                                    break breakPoint;
                                }
                            }
                        }
                        else {
                            target += gap;
                            cnt += gap;
                            pq.add(temp - gap);
                        }
                    }
                }
                else {
                    target++;
                    cnt++;
                    pq.add(temp - 1);
                }
            }

            System.out.println(cnt);
        }
        br.close();
    }
}