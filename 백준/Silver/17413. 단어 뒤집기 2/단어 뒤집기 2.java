import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int len = input.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBlocked = false;

        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pollLast() + "");
                }
                isBlocked = true;
                bw.write(c + "");
            }
            else if (c == '>') {
                bw.write('>' + "");
                isBlocked = false;
            }
            else if (isBlocked) {
                bw.write(c + "");
            }
            else if (c == ' ') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pollLast() + "");
                }
                bw.write(" ");
            }
            else {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pollLast() + "");
        }

        br.close();
        bw.close();

    }
}