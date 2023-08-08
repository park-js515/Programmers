import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> -o[1]));
        int sum = 0;

        for (int i = 0; i < 8; i++) {
            pq.add(new int[] {i + 1, Integer.parseInt(br.readLine())});
        }

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            int[] now = pq.poll();
            arr[i] = now[0];
            sum += now[1];
        }

        Arrays.sort(arr);
        
        System.out.println(sum);
        for (int i: arr) {
            System.out.print(i + " ");
        }
        br.close();
    }
}