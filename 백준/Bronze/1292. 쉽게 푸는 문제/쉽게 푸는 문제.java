import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]), B = Integer.parseInt(input[1]);
        A--;

        int num = 1;
        int dub = 0;
        int sum = 0;

        for (int i = 0; i < B; i++) {
            dub++;

            if (i >= A) {
                sum += num;
            }

            if (num == dub) {
                num++;
                dub = 0;
            }
        }

        System.out.println(sum);
        br.close();
    }
}