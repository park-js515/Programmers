import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static class Link implements Comparable<Link> {
        int s, e, cost;

        Link(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Link link) {
            return this.cost - link.cost;
        }
    }

    private static int[] grp;

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
        String[] input;

        input = br.readLine().split(" ");
        int n = pint(input[0]), m = pint(input[1]);
        grp = new int[n];

        for (int i = 1; i < n; i++) {
            grp[i] = i;
        }

        int before = 0;
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = pint(input[0]) - 1;
            int e = pint(input[1]) - 1;

            if (find(s) != find(e)) {
                union(s, e);
                before++;
            }
        }

        PriorityQueue<Link> links = new PriorityQueue<>();
        ArrayList<Link> arr = new ArrayList<>();
        int X = 0;
        int k = before;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    continue;
                }

                Link link = new Link(i, j, pint(input[j]));
                links.add(link);
            }
        }

        while(!links.isEmpty()) {
            Link link = links.poll();

            if (find(link.s) != find(link.e)) {
                union(link.s, link.e);
                X += link.cost;
                k++;

                arr.add(link);
                if (k == n - 2) {
                    break;
                }
            }
        }

        System.out.println(X + " " + (k - before));
        for (Link link: arr) {
            System.out.println((link.s + 1) + " " + (link.e + 1));
        }
        br.close();
    }
}