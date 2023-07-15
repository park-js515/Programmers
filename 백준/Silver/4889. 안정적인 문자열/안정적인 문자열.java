import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int test_case = 0;

        while (true) {
            test_case++;
            input = br.readLine();
            if (input.charAt(0) == '-') {
                break;
            }

            ArrayDeque<Boolean> stack = new ArrayDeque<>();
            int stackSize = 0;

            int size = input.length();
            for (int i = 0; i < size; i++) {
                if (input.charAt(i) == '{') {
                    stack.add(true);
                    stackSize++;
                }
                else {
                    if (stackSize > 0 && stack.peekLast()) {
                        stackSize--;
                        stack.pollLast();
                    }
                    else {
                        stackSize++;
                        stack.add(false);
                    }
                }
            }

            int open = 0;
            int close = 0;
            for (boolean i: stack) {
                if (i) {
                    open++;
                }
                else {
                    close++;
                }
            }

            int ans = 0;
            for (int i = 0; i < stackSize; i += 2) {
                boolean first = stack.poll();
                boolean second = stack.poll();

                if ((first && second) || (!first && !second)) {
                    ans++;
                }
                else {
                    ans += 2;
                }
            }

            System.out.println(test_case + ". " + ans);
        }

        br.close();
    }
}