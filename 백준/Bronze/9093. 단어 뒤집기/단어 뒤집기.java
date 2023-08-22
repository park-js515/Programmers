import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int size = input.length;

            for (int i = 0; i < size; i++) {
                int len = input[i].length();
                for (int j = len - 1; j >= 0; j--) {
                    bw.write(input[i].charAt(j) + "");
                }
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}