import java.io.*;
import java.util.*;

public class Main {
    private static int[] grp;

    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static int find(int a) {
        if (grp[a] == a) {
            return a;
        }

        grp[a] = find(grp[a]);
        return grp[a];
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        grp[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");

        int N = pint(input[0]), M = pint(input[1]), t = pint(input[2]);
        grp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            grp[i] = i;
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = pint(input[0]), b = pint(input[1]), c = pint(input[2]);
            pq.add(new Edge(a = a, b = b, c = c));
        }

        int cost = ((N - 2) * (N - 1) / 2) * t;
        int links = 0;

        while (links < N - 1) {
            Edge edge = pq.poll();

            if (find(edge.a) != find(edge.b)) {
                links++;
                union(edge.a, edge.b);
                cost += edge.c;
            }
        }

        System.out.println(cost);
    }

    private static class Edge implements Comparable<Edge> {
        int a, b, c;

        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Edge edge) {
            return this.c - edge.c;
        }
    }
}