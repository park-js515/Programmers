import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = pint(br.readLine());
        int[][] dp = new int[N + 1][3];

        int[] stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = pint(br.readLine());
        }

        int answer = 0;
        if (N == 1) {
            answer = stairs[1];
        } else if (N == 2) {
            answer = stairs[1] + stairs[2];
        } else {
            dp[1][1] = stairs[1];
            dp[2][1] = stairs[2];
            dp[2][2] = stairs[1] + stairs[2];

            for (int i = 3; i <= N; i++) {
                int stairValue = stairs[i];

                if (dp[i - 2][1] != 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 2][1] + stairValue);
                }
                if (dp[i - 2][2] != 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 2][2] + stairValue);
                }
                if (dp[i - 1][1] != 0) {
                    dp[i][2] = Math.max(dp[i][2], dp[i - 1][1] + stairValue);
                }
            }

            for (int i = 0; i < 3; i++) {
                answer = Math.max(answer, dp[N][i]);
            }
        }

        System.out.println(answer);
        br.close();
    }
}