// https://www.acmicpc.net/problem/3055
import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static int bfs(int R, int C, char[][] arr) {
        int[][] d = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        int[][] visited = new int[R][C];
        int sr = 0, sc = 0;
        ArrayDeque<int[]> water = new ArrayDeque<>();
        boolean sCheck = true;

         for (int i = 0; i < R; i++) {
            point: for (int j = 0; j < C; j++) {
                if (sCheck) {
                    if (arr[i][j] == 'S') {
                        sr = i;
                        sc = j;
                        sCheck = false;
                        continue point;
                    }
                }
                if (arr[i][j] == '*') {
                    water.add(new int[] {i, j});
                    continue point;
                }
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>(); // 고슴도치
        queue.add(new int[] {sr, sc});
        visited[sr][sc] = 1;


        while (!queue.isEmpty()) {
            int size1 = queue.size();
            int size2 = water.size();

            for (int i = 0; i < size2; i++) {
                int[] now = water.poll();
                int row = now[0];
                int col = now[1];

                endPoint1: for (int j = 0; j < 4; j++) {
                    int drow = row + d[j][0];
                    int dcol = col + d[j][1];

                    if (drow < 0 || drow >= R || dcol < 0 || dcol >= C) continue endPoint1;
                    if (arr[drow][dcol] == '*' || arr[drow][dcol] == 'X' || arr[drow][dcol] == 'D') {
                        continue endPoint1;
                    }

                    arr[drow][dcol] = '*';
                    water.add(new int[] {drow, dcol});
                }
            }

            for (int i = 0; i < size1; i++) {
                int[] now = queue.poll();
                int row = now[0];
                int col = now[1];

                for (int j = 0; j < 4; j++) {
                    int drow = row + d[j][0];
                    int dcol = col + d[j][1];

                    if (drow < 0 || drow >= R || dcol < 0 || dcol >= C) {
                        continue;
                    }
                    if (arr[drow][dcol] == 'D') {
                        return visited[row][col];
                    }
                    if (visited[drow][dcol] != 0 || arr[drow][dcol] != '.') continue;
                    visited[drow][dcol] = visited[row][col] + 1;
                    queue.add(new int[] {drow, dcol});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int R = pint(input[0]), C = pint(input[1]);
        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String st = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = st.charAt(j);
            }
        }

        int ans = bfs(R, C, arr);
        if (ans == -1) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(ans);
        }
        br.close();
    }
}