import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    private static long pLong(String s) {
        return Long.parseLong(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Long> stack = new ArrayDeque<>();
        ArrayDeque<Long> cnt = new ArrayDeque<>();
        long answer = 0;
        long N = pLong(br.readLine());

        stack.add(pLong(br.readLine()));
        cnt.add(0L);

        for (int i = 1; i < N; i++) {
            long next = pLong(br.readLine());

            while (!stack.isEmpty() && stack.peekLast() < next) {
                stack.pollLast();
                answer += cnt.pollLast() + 1;
            }

            if (!stack.isEmpty()) {
                if (stack.peekLast() > next) {
                    cnt.add(1L);
                } else {
                    cnt.add(cnt.peekLast() + 1);
                }
            } else {
                cnt.add(0L);
            }

            stack.add(next);
        }

        for (long c : cnt) {
            answer += c;
        }
        System.out.print(answer);
        br.close();
    }
}