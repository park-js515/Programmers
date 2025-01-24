import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int H = pint(input[0]), W = pint(input[1]);
        int[] arr = new int[W];
        input = br.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            arr[i] = pint(input[i]);
        }

        int[] leftMax = new int[W];
        leftMax[0] = arr[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[W];
        rightMax[W - 1] = arr[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        int answer = 0;

        for (int i = 1; i < W - 1; i++) {
            int t1 = Math.min(leftMax[i - 1], rightMax[i + 1]);
            int t2 = Math.max(t1 - arr[i], 0);
            answer += t2;
        }

        System.out.println(answer);
        br.close();
    }
}