import java.io.*;
import java.util.*;

public class Main {
    static int[] dim(int type) {
        if (type == 0) {
            return new int[] {4, 1};
        }
        else if (type == 1) {
            return new int[] {1, 4};
        }
        else if (type == 2) {
            return new int[] {2, 2};
        }
        else if (3 <= type && type <= 10) {
            return new int[] {3, 2};
        }
        return new int[] {2, 3};
    }

    static int[][][] pos = {
            { {0, 0}, {1, 0}, {2, 0}, {3, 0} }, // 0
            { {0, 0}, {0, 1}, {0, 2}, {0, 3} },
            { {0, 0}, {0, 1}, {1, 0}, {1, 1} },
            { {0, 0}, {1, 0}, {2, 0}, {2, 1} },
            { {0, 1}, {1, 1}, {2, 0}, {2, 1} },
            { {0, 0}, {0, 1}, {1, 1}, {2, 1} }, // 5
            { {0, 0}, {0, 1}, {1, 0}, {2, 0} },
            { {0, 0}, {1, 0}, {1, 1}, {2, 1} },
            { {0, 1}, {1, 0}, {1, 1}, {2, 0} },
            { {0, 1}, {1, 0}, {1, 1}, {2, 1} },
            { {0, 0}, {1, 0}, {1, 1}, {2, 0} }, // 10
            { {0, 0}, {0, 1}, {0, 2}, {1, 0} },
            { {0, 0}, {0, 1}, {0, 2}, {1, 2} },
            { {0, 0}, {1, 0}, {1, 1}, {1, 2} },
            { {0, 2}, {1, 0}, {1, 1}, {1, 2} },
            { {0, 1}, {0, 2}, {1, 0}, {1, 1} }, // 15
            { {0, 0}, {0, 1}, {1, 1}, {1, 2} },
            { {0, 1}, {1, 0}, {1, 1}, {1, 2} },
            { {0, 0}, {0, 1}, {0, 2}, {1, 1} }
    };

    static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]);
        int[][] field = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = pint(input[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < 19; i++) {
            int[] dim = dim(i);
            int[][] now_pos = pos[i];

            for (int j = 0; j < N - dim[0] + 1; j++) {
                for (int k = 0; k < M - dim[1] + 1; k++) {
                    int temp = 0;
                    for (int l = 0; l < 4; l++) {
                        temp += field[j+now_pos[l][0]][k+now_pos[l][1]];
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        System.out.println(ans);
        br.close();
        bw.close();
    }
}