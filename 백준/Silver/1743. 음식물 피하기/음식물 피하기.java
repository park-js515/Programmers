import java.io.*;
import java.util.*;

public class Main {
    static int pint(String s) {
        return Integer.parseInt(s);
    }

    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int ans = 0;

    static void bfs(int N, int M, int r, int c, boolean[][] field, boolean[][] visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int cnt = 1;
        queue.add(new int[] {r, c});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int drow = now[0] + d[i][0];
                int dcol = now[1] + d[i][1];

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= M || visited[drow][dcol] || !field[drow][dcol]) {
                    continue;
                }

                cnt++;
                visited[drow][dcol] = true;
                queue.add(new int[] {drow, dcol});
            }
        }

        ans = Math.max(ans, cnt);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]), K = pint(input[2]);
        boolean[][] field = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            field[pint(input[0]) - 1][pint(input[1]) - 1] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && field[i][j]) {
                    visited[i][j] = true;
                    bfs(N, M, i, j, field, visited);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}