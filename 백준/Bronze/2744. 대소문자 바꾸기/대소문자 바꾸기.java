import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int len = input.length();
        int gap = 'a' - 'A';

        for (int i = 0; i < len; i++) {
            char temp = input.charAt(i);
            if (temp >= 'a') {
                temp -= gap;
            }
            else {
                temp += gap;
            }
            bw.write((char) temp + "");
        }

        bw.close();
        br.close();
    }
}