import java.io.*;
import java.util.*;

public class Main {
    public static int pint(String s) {
        return Integer.parseInt(s);
    }

    static boolean[][] field;
    static ArrayList<Integer> lst = new ArrayList<>();

    public static void bfs(int N, int M, int v1, int v2) {
        int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { v1, v2 });
        field[v1][v2] = true;
        int[] now;
        int row, col, drow, dcol;
        int area = 0;

        while (!queue.isEmpty()) {
            now = queue.poll();
            row = now[0]; col = now[1];
            area++;

            for (int i=0;i<4;i++) {
                drow = row+d[i][0];
                dcol = col+d[i][1];

                if (0<=drow && drow<N && 0<=dcol && dcol<M && !field[drow][dcol]) {
                    field[drow][dcol] = true;
                    queue.add(new int[] { drow, dcol });
                }
            }
        }

        lst.add(area);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int M, N, K;
        st = new StringTokenizer(br.readLine());
        M = pint(st.nextToken()); N = pint(st.nextToken()); K = pint(st.nextToken());
        field = new boolean[N][M];
        int x1, y1, x2, y2;

        for (int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            x1 = pint(st.nextToken()); y1 = pint(st.nextToken()); x2 = pint(st.nextToken()); y2 = pint(st.nextToken());

            for (int x=x1;x<x2;x++) {
                for (int y=y1;y<y2;y++) {
                    field[x][y] = true;
                }
            }
        }

        int cnt = 0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (!field[i][j]) {
                    cnt++;
                    bfs(N, M, i, j);
                }
            }
        }
        Collections.sort(lst);

        bw.write(cnt+"\n");
        for (Integer integer : lst) {
            bw.write(integer + " ");
        }
        br.close();
        bw.close();
    }
}