import java.io.*;
import java.util.*;

public class Main {
    static int[][] field;
    static int[][] d = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int ans = 11;

    // 상 하 좌 우
    static boolean check (int[] red, int[] blue, int type) {
        if (type == 0 && red[0] <= blue[0]) {
            return true;
        }
        else if (type == 1 && red[0] >= blue[0]) {
            return true;
        }
        else if (type == 2 && red[1] <= blue[1]) {
            return true;
        }
        else if (type == 3 && red[1] >= blue[1]) {
            return true;
        }
        return false;
    }

    static void dfs(int[] red, int[] blue, int depth) {
        if (ans <= depth) {
            return;
        }
        if (field[blue[0]][blue[1]] == 2) {
            return;
        }
        if (field[red[0]][red[1]] == 2) {
            ans = depth;
        }
        if (depth == 10) {
            return;
        }

        for (int i = 0; i < 4; i ++) {
            int[] red_copy = new int[2];
            red_copy[0] = red[0];
            red_copy[1] = red[1];
            int[] blue_copy = new int[2];
            blue_copy[0] = blue[0];
            blue_copy[1] = blue[1];

            int dy = d[i][0];
            int dx = d[i][1];

            if (check(red, blue, i)) {
                for (int j = 0; j < 10; j++) {
                    red_copy[0] += dy;
                    red_copy[1] += dx;
                    int temp = field[red_copy[0]][red_copy[1]];

                    if (temp == 2) {
                        break;
                    }
                    else if (temp == 1 && !(red_copy[0] == blue[0] && red_copy[1] == blue[1])) {
                        continue;
                    }
                    else {
                        red_copy[0] -= dy;
                        red_copy[1] -= dx;
                        break;
                    }
                }

                for (int j = 0; j < 10; j++) {
                    blue_copy[0] += dy;
                    blue_copy[1] += dx;
                    int temp = field[blue_copy[0]][blue_copy[1]];

                    if (temp == 2) {
                        break;
                    }
                    else if (temp == 1 && !(blue_copy[0] == red_copy[0] && blue_copy[1] == red_copy[1])) {
                        continue;
                    }
                    else {
                        blue_copy[0] -= dy;
                        blue_copy[1] -= dx;
                        break;
                    }
                }
            }
            else {
                for (int j = 0; j < 10; j++) {
                    blue_copy[0] += dy;
                    blue_copy[1] += dx;
                    int temp = field[blue_copy[0]][blue_copy[1]];

                    if (temp == 2) {
                        break;
                    }
                    else if (temp == 1 && !(blue_copy[0] == red[0] && blue_copy[1] == red[1])) {
                        continue;
                    }
                    else {
                        blue_copy[0] -= dy;
                        blue_copy[1] -= dx;
                        break;
                    }
                }
                for (int j = 0; j < 10; j++) {
                    red_copy[0] += dy;
                    red_copy[1] += dx;
                    int temp = field[red_copy[0]][red_copy[1]];

                    if (temp == 2) {
                        break;
                    }
                    else if (temp == 1 && !(red_copy[0] == blue_copy[0] && red_copy[1] == blue_copy[1])) {
                        continue;
                    }
                    else {
                        red_copy[0] -= dy;
                        red_copy[1] -= dx;
                        break;
                    }
                }
            }
            dfs(red_copy, blue_copy, depth+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        field = new int[N][M];
        int[] red = {0, 0}, blue = {0, 0}, goal = {0, 0};
        boolean r_find = true, b_find = true, g_find = true;

        for (int i =  0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = line.charAt(j);
                if (temp != '#') {
                    field[i][j] = 1;
                }

                if (r_find && temp == 'R') {
                    red = new int[] {i, j};
                    r_find = false;
                }
                if (b_find && temp == 'B') {
                    blue = new int[] {i, j};
                    b_find = false;
                }
                if (g_find && temp == 'O') {
                    goal = new int[] {i, j};
                    field[i][j] = 2;
                    g_find = false;
                }
            }
        }
        dfs(red, blue, 0);
        if (ans == 11) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
        br.close();
        bw.close();
    }
}