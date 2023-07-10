import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = pint(br.readLine()), K = pint(br.readLine());

        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
        int[][] d_chage = {{2, 3}, {3, 2}, {1, 0}, {0, 1}};
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('L', 0);
        map.put('D', 1);

        int[][] field = new int[N][N];
        field[0][0] = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {0, 0});

        int now_dir = 3;

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            field[pint(input[0])-1][pint(input[1])-1] = 2;
        }

        int L = pint(br.readLine());
        int time = 0;
        boolean go = true;

        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            int X = pint(input[0]);
            char C = input[1].charAt(0);
            int next_dir = d_chage[now_dir][map.get(C)];

            for (;time < X; time++) {
                int[] now = queue.getFirst();
                int drow = now[0] + d[now_dir][0];
                int dcol = now[1] + d[now_dir][1];

                if (0 <= drow && drow < N && 0 <= dcol && dcol < N) {
                    if (field[drow][dcol] == 0) {
                        int[] temp = queue.pollLast();
                        field[temp[0]][temp[1]] = 0;
                        field[drow][dcol] = 1;
                        queue.addFirst(new int[] {drow, dcol});
                        continue;
                    }
                    else if (field[drow][dcol] == 2) {
                        field[drow][dcol] = 1;
                        queue.addFirst(new int[] {drow, dcol});
                        continue;
                    }
                }
                go = false;
                break;
            }
            if (!go) {
                break;
            }
            now_dir = next_dir;
        }

        if (go) {
            time--;
            while (true) {
                time++;
                int[] now = queue.getFirst();
                int drow = now[0] + d[now_dir][0];
                int dcol = now[1] + d[now_dir][1];

                if (0 <= drow && drow < N && 0 <= dcol && dcol < N) {
                    if (field[drow][dcol] == 0) {
                        int[] temp = queue.pollLast();
                        field[temp[0]][temp[1]] = 0;
                        field[drow][dcol] = 1;
                        queue.addFirst(new int[] {drow, dcol});
                        continue;
                    }
                    else if (field[drow][dcol] == 2) {
                        field[drow][dcol] = 1;
                        queue.addFirst(new int[] {drow, dcol});
                        continue;
                    }
                }
                break;
            }
        }
        System.out.println(time+1);
        br.close();
        bw.close();
    }
}