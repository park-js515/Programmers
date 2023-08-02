import java.io.*;

public class Main {
    private static int ftn(int num) {
        int ret = num;

        while (num > 0) {
            ret += num % 10;
            num /= 10;
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int temp = ftn(i);
            if (temp <= 10000) {
                arr[temp] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!arr[i]) {
                bw.write(i + "\n");
            }
        }

        bw.close();
    }
}