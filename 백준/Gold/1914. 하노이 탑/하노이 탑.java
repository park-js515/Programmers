import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static boolean print = true;

    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static BigInteger multiple(int exp) {
        BigInteger result = BigInteger.valueOf(1);
        BigInteger cur = BigInteger.valueOf(2);

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result.multiply(cur);
            }
            cur = cur.multiply(cur);
            exp >>= 1;
        }

        return result;
    }

    private static void hanoi(int n, int first, int second, int third) throws IOException {
        if (n <= 0) {
            return;
        }

        hanoi(n - 1, first, third, second);
        bw.write(first + " " + third + "\n");
        hanoi(n - 1, second, first, third);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int n = pint(input);
        if (n > 20) {
            print = false;
        }

        bw.write(multiple(n).subtract(BigInteger.valueOf(1)) + "\n");
        if (print) {
            hanoi(n, 1, 2, 3);
        }

        br.close();
        bw.close();
    }
}