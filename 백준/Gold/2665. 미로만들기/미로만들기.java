import java.io.*;
import java.util.*;

public class Main {
    private static class Item implements Comparable<Item> {
        int r, c, cost;

        Item(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Item o) {
            return this.cost - o.cost;
        }
    }

    private static int dijkstra(int N, boolean[][] field) {
        int[][] distance = new int[N][N];
        int[][] d = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;
        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.add(new Item(0, 0, 0));

        while (!pq.isEmpty()) {
            Item item = pq.poll();

            for (int i = 0; i < 4; i++) {
                int drow = item.r + d[i][0];
                int dcol = item.c + d[i][1];

                if (drow < 0 || drow >= N || dcol < 0 || dcol >= N) continue;
                int nxtCost = field[drow][dcol] ? item.cost : item.cost + 1;
                if (distance[drow][dcol] > nxtCost) {
                    distance[drow][dcol] = nxtCost;
                    pq.add(new Item(drow, dcol, nxtCost));
                }
            }
        }

        return distance[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] field = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = input.charAt(j) - '0' == 1;
            }
        }

        System.out.println(dijkstra(N, field));
        br.close();
    }
}