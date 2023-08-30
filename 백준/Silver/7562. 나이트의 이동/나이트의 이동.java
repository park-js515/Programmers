import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static int[][] move = {
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2},
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1}
    };

    private static int bfs(int l, int[][] visited, int sr, int sc, int er, int ec) {
          visited[sr][sc] = 0;
          ArrayDeque<int[]> queue = new ArrayDeque<>();
          queue.add(new int[] {sr, sc});

          while (!queue.isEmpty()) {
              int[] now = queue.poll();
              int r = now[0];
              int c = now[1];

              for (int i = 0; i < 8; i++) {
                  int dr = r + move[i][0];
                  int dc = c + move[i][1];

                  if (dr < 0 || dr >= l || dc < 0 || dc >= l || visited[dr][dc] != -1) {
                      continue;
                  }

                  visited[dr][dc] = visited[r][c] + 1;
                  queue.add(new int[] {dr, dc});

                  if (visited[er][ec] != -1) {
                      return visited[er][ec];
                  }
              }
          }

          return 0;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int T = pint(br.readLine());
        for (int t = 0; t < T; t++) {
            int l = pint(br.readLine());
            input = br.readLine().split(" ");
            int sr = pint(input[0]), sc = pint(input[1]);
            input = br.readLine().split(" ");
            int er = pint(input[0]), ec = pint(input[1]);

            int[][] visited = new int[l][l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    visited[i][j] = -1;
                }
            }
            int ans = bfs(l, visited, sr, sc, er, ec);
            System.out.println(ans);
        }

        br.close();
    }
}