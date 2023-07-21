import java.util.*;
import java.io.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    static class Person implements Comparable<Person> {
        int D;
        int H;
        int line;
        boolean isK;


        Person(int D, int H, int i, int M, int K) {
            this.D = D;
            this.H = H;
            this.line = i % M;
            this.isK = i == K;
        }

        @Override
        public int compareTo(Person person) {
            if (this.D == person.D) {
                if (this.H == person.H) {
                    return this.line - person.line;
                }
                return person.H - this.H;
            }
            return person.D - this.D;
        }
    }
    // 근무 일수 up, 급한 정도 up, 줄 번호 down
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        PriorityQueue<Person> pq = new PriorityQueue<>();

        input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]), K = pint(input[2]);
        LinkedList<Person>[] groups = new LinkedList[M];

        for (int i = 0; i < M; i++) {
            groups[i] = new LinkedList<Person>();
        }

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            groups[i % M].add(new Person(pint(input[0]), pint(input[1]), i, M, K));
        }

        for (int i = 0; i < M; i++) {
            if (!groups[i].isEmpty()) {
                pq.add(groups[i].remove(0));
            }
        }

        int cnt = 0;
        while (true) {
            cnt++;

            Person person = pq.poll();

            if (person.isK) {
                break;
            }

            if (!groups[person.line].isEmpty()) {
                pq.add(groups[person.line].poll());
            }
        }

        System.out.println(cnt - 1);
        br.close();
    }
}