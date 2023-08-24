import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = pint(input[0]), N = pint(input[1]);
        int[][] d = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int[][] field = new int[N][M];
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = st.charAt(j) - '0';
            }
        }

        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        visited[0][0] = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            for (int i = 0; i < 4; i++) {
                int drow = row + d[i][0];
                int dcol = col + d[i][1];

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= M) {
                    continue;
                }

                if (field[drow][dcol] == 1 && visited[drow][dcol] > visited[row][col] + 1) {
                    visited[drow][dcol] = visited[row][col] + 1;
                    queue.add(new int[] {drow, dcol});
                }
                else if (field[drow][dcol] == 0 && visited[drow][dcol] > visited[row][col]) {
                    visited[drow][dcol] = visited[row][col];
                    queue.add(new int[] {drow, dcol});
                }
            }
        }

        System.out.println(visited[N - 1][M - 1]);
        br.close();
    }
}