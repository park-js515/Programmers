import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static int[][] field;

    private static int[] dice = {1, 2, 3, 4, 5, 6};

    private static int[] pos = {0, 0};

    private static void move(int dir) {
        switch (dir) {
            case 0: // 상
                pos[0]--;
                dice = new int[] {dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
                break;
            case 1: // 하
                pos[0]++;
                dice = new int[] {dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
                break;
            case 2: // 좌
                pos[1]--;
                dice = new int[] {dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
                break;
            case 3: // 우
                pos[1]++;
                dice = new int[] {dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
                break;
        }
    }

    private static int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private static int rot(int dir, int Num) {
        if (Num == 0) {
            if (dir == 0) { // dir == 0 : 반시계
                return 2;
            }
            return 3;
        }
        else if (Num == 1) {
            if (dir == 0) {
                return 3;
            }
            return 2;
        }
        else if (Num == 2) {
            if (dir == 0) {
                return 1;
            }
            return 0;
        }
        else {
            if (dir == 0) {
                return 0;
            }
            return 1;
        }
    }

    private static int changeDir(int a, int b) {
        if (a > b) {
            return 1; // 시계 방향
        }
        else if (a < b) {
            return 0; // 반시계 방향
        }
        return -1; // 변화 없음
    }

    private static int bfs(int N, int M, int r, int c) {
        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        int score = field[r][c];
        int val = field[r][c];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];

            for (int i = 0; i < 4; i++) {
                int nxtR = nowR + direction[i][0];
                int nxtC = nowC + direction[i][1];

                if (nxtR < 0 || nxtR >= N || nxtC < 0 || nxtC >= M) {
                    continue;
                }

                if (field[nxtR][nxtC] == val && !visited[nxtR][nxtC]) {
                    queue.add(new int[] {nxtR, nxtC});
                    visited[nxtR][nxtC] = true;
                    score += val;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]), K = pint(input[2]);
        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = pint(input[j]);
            }
        }

        HashMap<Integer,Integer> rev = new HashMap<>();
        rev.put(0, 1);
        rev.put(1, 0);
        rev.put(2, 3);
        rev.put(3, 2);

        int score = 0;
        int nowDir = 3;

        for (int i = 0; i < K; i++) {
            int tempRow = pos[0] + direction[nowDir][0];
            int tempCol = pos[1] + direction[nowDir][1];

            if (tempRow < 0 || tempRow >= N || tempCol < 0 || tempCol >= M) {
                nowDir = rev.get(nowDir);
            }

            move(nowDir);
            score += bfs(N, M, pos[0], pos[1]);

            int change = changeDir(dice[5], field[pos[0]][pos[1]]);
            if (change != -1) {
                nowDir = rot(change, nowDir);
            }
        }
        bw.write(score+"");
        br.close();
        bw.close();
    }
}