import java.io.*;
import java.util.*;

public class Main {
    static int pint(String s) {
        return Integer.parseInt(s);
    }

    static int[][] d = {
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {1, 1}, {1, 0}, {1, -1}
    };

    static int[][] field;
    static ArrayList<int[]> pos = new ArrayList<>();

    static void move(int N, int Direction, int Speed) {
        int[][] nxt_pos = new int[pos.size()][2];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < pos.size(); i++) {
            int drow = (pos.get(i)[0] + d[Direction][0] * Speed) % N;
            int dcol = (pos.get(i)[1] + d[Direction][1] * Speed) % N;

            if (drow < 0) {
                drow += N;
            }
            if (dcol < 0) {
                dcol += N;
            }

            field[drow][dcol]++;
            visited[drow][dcol] = true;
            nxt_pos[i][0] = drow;
            nxt_pos[i][1] = dcol;
        }

        //
        int[][] nxt_field = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nxt_field[i][j] = field[i][j];
            }
        }

        for (int[] now: nxt_pos) {
            int cnt = 0;
            for (int i = 1; i < 8; i += 2) {
                int drow = now[0] + d[i][0];
                int dcol = now[1] + d[i][1];

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N || field[drow][dcol] == 0) {
                    continue;
                }
                cnt++;
            }
            nxt_field[now[0]][now[1]] += cnt;
        }

        field = nxt_field;
        pos.clear();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (field[i][j] >= 2) {
                    field[i][j] -= 2;
                    pos.add(new int[] {i, j});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]);
        field = new int[N][N];
        int[][] temp = new int[][] {
                {N - 2, 0}, {N - 2, 1},
                {N - 1, 0}, {N - 1, 1}
        };

        pos.addAll(Arrays.asList(temp));

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = pint(input[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int Direction = pint(input[0]) - 1;
            int Speed = pint(input[1]);
            move(N, Direction, Speed);
        }

        int SUM = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                SUM += field[i][j];
            }
        }

        System.out.println(SUM);
        br.close();
    }
}