import java.io.*;
import java.util.*;

public class Main {
    public static int pint(String s) {
        return Integer.parseInt(s);
    }

    static int[][] field;
    static int[][] visited;
    static boolean go = true;

    public static void bfs(int N, int L, int R, int idx, int v1, int v2) {
        int[][] d = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {v1, v2});
        visited[v1][v2] = idx;
        int idx_count = 1;
        int idx_sum = field[v1][v2];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int drow = now[0] + d[i][0];
                int dcol = now[1] + d[i][1];

                if (0 <= drow && drow < N && 0 <= dcol && dcol < N && visited[drow][dcol] == 0) {
                    int temp = Math.abs(field[now[0]][now[1]] - field[drow][dcol]);
                    if (L <= temp && temp <= R) {
                        visited[drow][dcol] = idx;
                        queue.add(new int[] {drow, dcol});
                        idx_count++;
                        idx_sum += field[drow][dcol];
                    }
                }
            }
        }
        if (idx_count > 1) {
            int temp = idx_sum/idx_count;
            int nxt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == idx) {
                        nxt += Math.abs(field[i][j] - temp);
                        field[i][j] = temp;
                    }
                }
            }

            if (nxt > 0) {
                go = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), L = pint(input[1]), R = pint(input[2]);
        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = pint(input[j]);
            }
        }

        int cnt = 0;

        while (go) {
            go = false;
            visited = new int[N][N];
            int idx = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        bfs(N, L, R, ++idx, i, j);
                    }
                }
            }

            if (go) {
                cnt++;
            }
        }
        bw.write(cnt+"");
        br.close();
        bw.close();
    }
}