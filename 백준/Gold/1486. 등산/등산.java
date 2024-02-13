import java.io.*;
import java.util.PriorityQueue;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static int getHeight(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        }
        return ch - 'a' + 26;
    }

    private static int[][] dijkstra1(int N, int M, int T, int[][] map) {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = 100_000_000;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dist[now[0]][now[1]] > now[2]) {
                dist[now[0]][now[1]] = now[2];
            } else {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int dr = now[0] + d[i][0];
                int dc = now[1] + d[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M) {
                    continue;
                }

                int before = map[now[0]][now[1]];
                int after = map[dr][dc];
                int cost = before >= after ? now[2] + 1 : now[2] + (int) Math.pow(before - after, 2);
                if (dist[dr][dc] > cost && Math.abs(before - after) <= T) {
                    pq.add(new int[]{dr, dc, cost});
                }
            }
        }

        return dist;
    }

    private static int dijkstra2(int N, int M, int T, int[][] map, int[] start) {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = 100_000_000;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dist[now[0]][now[1]] > now[2]) {
                dist[now[0]][now[1]] = now[2];
                if (now[0] == 0 && now[1] == 0) {
                    break;
                }
            } else {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int dr = now[0] + d[i][0];
                int dc = now[1] + d[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M) {
                    continue;
                }

                int before = map[now[0]][now[1]];
                int after = map[dr][dc];
                int cost = before >= after ? now[2] + 1 : now[2] + (int) Math.pow(before - after, 2);
                if (dist[dr][dc] > cost && Math.abs(before - after) <= T) {
                    pq.add(new int[]{dr, dc, cost});
                }
            }
        }

        return dist[0][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]), T = pint(input[2]), D = pint(input[3]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = getHeight(line.charAt(j));
            }
        }
        int[][] cost1 = dijkstra1(N, M, T, map);
        int[][] cost2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cost1[i][j] != 100_000_000) {
                    cost2[i][j] = dijkstra2(N, M, T, map, new int[]{i, j});
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cost1[i][j] + cost2[i][j] <= D) {
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}