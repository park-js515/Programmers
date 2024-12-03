import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer>[][] map = new HashMap[100][100];
    private int[][] points;
    private int[][] routes;

    private void init(int[][] points, int[][] routes) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j]--;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[0].length; j++) {
                routes[i][j]--;
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                map[i][j] = new HashMap<>();
            }
        }

        this.points = points;
        this.routes = routes;
    }

    private int move(int from, int to, int cnt) {
        int fr = points[from][0];
        int fc = points[from][1];
        int tr = points[to][0];
        int tc = points[to][1];

        int sign1 = fr < tr ? 1 : -1;
        int sign2 = fc < tc ? 1 : -1;

        if (fr != tr) {
            if (sign1 > 0) {
                fr++;
                for (int i = fr; i <= tr; i++) {
                    map[i][fc].put(cnt, map[i][fc].getOrDefault(cnt, 0) + 1);
                    cnt++;
                }
            } else {
                fr--;
                for (int i = fr; i >= tr; i--) {
                    map[i][fc].put(cnt, map[i][fc].getOrDefault(cnt, 0) + 1);
                    cnt++;
                }
            }
        }

        if (fc != tc) {
            if (sign2 > 0) {
                fc++;
                for (int i = fc; i <= tc; i++) {
                    map[tr][i].put(cnt, map[tr][i].getOrDefault(cnt, 0) + 1);
                    cnt++;
                }
            } else {
                fc--;
                for (int i = fc; i >= tc; i--) {
                    map[tr][i].put(cnt, map[tr][i].getOrDefault(cnt, 0) + 1);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public int solution(int[][] points, int[][] routes) {
        init(points, routes);

        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            int cnt = 1;
            int fr = points[route[0]][0];
            int fc = points[route[0]][1];
            map[fr][fc].put(0, map[fr][fc].getOrDefault(0, 0) + 1);
            for (int j = 0; j < route.length - 1; j++) {
                cnt = move(route[j], route[j + 1], cnt);
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (!map[i][j].isEmpty()) {
                    for (int k : map[i][j].values()) {
                        if (k >= 2) {
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}