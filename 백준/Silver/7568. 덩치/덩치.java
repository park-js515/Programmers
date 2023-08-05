import java.util.*;
import java.io.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = pint(br.readLine());
        int[][] arr = new int[n][2];
        int[] cnt = new int[n];
        String[] input;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            arr[i][0] = pint(input[0]);
            arr[i][1] = pint(input[1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    cnt[j]++;
                }
                else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    cnt[i]++;
                }
            }
        }

        for (int i: cnt) {
            System.out.print(i+1 + " ");
        }
        br.close();
    }
}