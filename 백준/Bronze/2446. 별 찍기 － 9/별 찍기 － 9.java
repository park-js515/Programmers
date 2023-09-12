import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int num = N * 2 - 1;

        for (int i = -N + 1; i <= N - 1; i++) {
            boolean check = false;
            for (int j = -N + 1; j <= N - 1; j++) {
                if (i + j <= 0 && i - j <= 0) {
                    check = true;
                    bw.write("*");
                }
                else if (i + j >= 0 && i - j >= 0) {
                    check = true;
                    bw.write("*");
                }
                else if (check) {
                    break;
                }
                else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        bw.close();
    }
}