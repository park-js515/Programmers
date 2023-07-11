import java.util.*;
import java.io.*;

public class Main {
    static int pint(String s) {
        return Integer.parseInt(s);
    }

    static int[][] field = new int[501][501];

    static int dijkstra() {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[501][501];
        int[][] distance = new int[501][501];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[2]));

        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;
        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty() && !visited[500][500]) {
            int[] now = pq.poll();
            int row = now[0];
            int col = now[1];
            int now_cost = now[2];

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int drow = row + d[i][0];
                int dcol = col + d[i][1];
                int cost = 0;

                if (drow < 0 || drow >= 501 || dcol < 0 || dcol >= 501) {
                    continue;
                }

                if (field[drow][dcol] == 1) {
                    cost = 1;
                }
                else if (field[drow][dcol] == 2) {
                    continue;
                }

                if (distance[drow][dcol] > now_cost + cost) {
                    distance[drow][dcol] = now_cost + cost;
                    pq.add(new int[] {drow, dcol, distance[drow][dcol]});
                }
            }
        }

        if (distance[500][500] == Integer.MAX_VALUE) {
            return -1;
        }
        return distance[500][500];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = pint(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int X1 = pint(input[0]), Y1 = pint(input[1]);
            int X2 = pint(input[2]), Y2 = pint(input[3]);

            if (X1 > X2) {
                int temp = X1;
                X1 = X2;
                X2 = temp;
            }

            if (Y1 > Y2) {
                int temp = Y1;
                Y1 = Y2;
                Y2 = temp;
            }

            for (int j = X1; j <= X2; j++) {
                for (int k = Y1; k <= Y2; k++) {
                    field[j][k] = Math.max(field[j][k], 1);
                }
            }
        }

        int M = pint(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int X1 = pint(input[0]), Y1 = pint(input[1]);
            int X2 = pint(input[2]), Y2 = pint(input[3]);

            if (X1 > X2) {
                int temp = X1;
                X1 = X2;
                X2 = temp;
            }

            if (Y1 > Y2) {
                int temp = Y1;
                Y1 = Y2;
                Y2 = temp;
            }

            for (int j = X1; j <= X2; j++) {
                for (int k = Y1; k <= Y2; k++) {
                    field[j][k] = Math.max(field[j][k], 2);
                }
            }
        }

        int ans = dijkstra();
        System.out.println(ans);
        br.close();
    }
}