import java.io.*;
import java.util.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
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

        grp[y] = grp[x];
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = pint(br.readLine());
        grp = new int[N];

        for (int i = 1; i < N; i++) {
            grp[i] = i;
        }

        ArrayList<Link> links = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < i; j++) {
                links.add(new Link(i, j, pint(input[j])));
            }
        }

        Collections.sort(links);

        int k = 0;
        long s = 0;
        for (Link link: links) {
            if (find(link.s) != find(link.e)) {
                union(link.s, link.e);
                k++;
                s+= link.cost;

                if (k == N - 1) {
                    break;
                }
            }
        }

        System.out.println(s);
        br.close();
    }
}