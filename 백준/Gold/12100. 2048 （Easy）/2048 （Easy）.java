import java.io.*;
import java.util.*;

public class Main {
    static int pint(String s) {
        return Integer.parseInt(s);
    }

    static int ans = 0;

    static int find_max(int[][] field) {
        int ret = 0;
        for (int[] row: field) {
            for (int item: row) {
                ret = Math.max(ret, item);
            }
        }
        return ret;
    }

    static void change(int N, int type, int order, int[][] field) {
        int[] nxt = new int[N];

        if (type == 0) { // 오른쪽
            int[] temp = field[order];
            int idx = N - 1;
            boolean go = false;
            int before = 0;

            for (int i = N-1; i >= 0; i--) {
                if (temp[i] > 0) {
                    if (go && before == temp[i]) {
                        nxt[idx] = before * 2;
                        idx--;
                        before = 0;
                        go = false;
                    }
                    else {
                        if (before > 0) {
                            nxt[idx] = before;
                            idx--;
                        }
                        go = true;
                        before = temp[i];
                    }
                }
            }

            if (before > 0) {
                nxt[idx] = before;
            }

            for (int i = 0; i < N; i++) {
                field[order][i] = nxt[i];
            }
        }
        else if (type == 1) { // 왼쪽
            int[] temp = field[order];
            int idx = 0;
            boolean go = false;
            int before = 0;

            for (int i = 0; i < N; i++) {
                if (temp[i] > 0) {
                    if (go && before == temp[i]) {
                        nxt[idx] = before * 2;
                        idx++;
                        before = 0;
                        go = false;
                    }
                    else {
                        if (before > 0) {
                            nxt[idx] = before;
                            idx++;
                        }
                        go = true;
                        before = temp[i];
                    }
                }
            }

            if (before > 0) {
                nxt[idx] = before;
            }

            for (int i = 0; i < N; i++) {
                field[order][i] = nxt[i];
            }
        }
        else if (type == 2) { // 위
            int[] temp = new int[N];
            for (int i = 0; i < N; i++) {
                temp[i] = field[i][order];
            }
            int idx = 0;
            boolean go = false;
            int before = 0;

            for (int i = 0; i < N; i++) {
                if (temp[i] > 0) {
                    if (go && before == temp[i]) {
                        nxt[idx] = before * 2;
                        idx++;
                        before = 0;
                        go = false;
                    }
                    else {
                        if (before > 0) {
                            nxt[idx] = before;
                            idx++;
                        }
                        go = true;
                        before = temp[i];
                    }
                }
            }

            if (before > 0) {
                nxt[idx] = before;
            }

            for (int i = 0; i < N; i++) {
                field[i][order] = nxt[i];
            }

        }
        else if (type == 3) { // 아래
            int[] temp = new int[N];
            for (int i = 0; i < N; i++) {
                temp[i] = field[i][order];
            }
            int idx = N - 1;
            boolean go = false;
            int before = 0;

            for (int i = N-1; i >= 0; i--) {
                if (temp[i] > 0) {
                    if (go && before == temp[i]) {
                        nxt[idx] = before * 2;
                        idx--;
                        before = 0;
                        go = false;
                    }
                    else {
                        if (before > 0) {
                            nxt[idx] = before;
                            idx--;
                        }
                        go = true;
                        before = temp[i];
                    }
                }
            }

            if (before > 0) {
                nxt[idx] = before;
            }

            for (int i = 0; i < N; i++) {
                field[i][order] = nxt[i];
            }
        }
    }

    static int[][] COPY(int N, int[][] now_field) {
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret[i][j] = now_field[i][j];
            }
        }
        return ret;
    }

    static void dfs(int[][] now_field, int depth, int N) {
        if (depth == 5) {
            ans = Math.max(ans, find_max(now_field));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] nxt_field = COPY(N, now_field);

            for (int j = 0; j < N; j++) {
                change(N, i, j, nxt_field);
            }
            dfs(nxt_field, depth+1, N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = pint(br.readLine());
        int[][] field = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = pint(input[j]);
            }
        }

        dfs(field, 0, N);
        System.out.println(ans);
        br.close();
        bw.close();
    }
}