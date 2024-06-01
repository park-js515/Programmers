// https://tech.kakao.com/posts/342
// 사람이 가장 많을 때의 락커의 최적해
import java.util.*;


class Solution {
    private int L1(Pair p1, Pair p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    public int solution(int n, int m, int[][] timetable) {
        int[]  se = new int[1322];
        
        for (int[] t: timetable) {
            se[t[0]]++;
            se[t[1] + 1]--;
        }
        
        int temp = 0;
        int max = 0;
        for (int i = 600; i <= 1320; i++) {
            temp += se[i];
            max = Math.max(max, temp);
        }
        
        int answer = 0;
        if (max <= 1) return answer;
        
        point1: for (int d = 2 * (n - 1); d >= 1; d--) {
            for (int c = 0; c < n; c++) {
                List<Pair> list = new ArrayList<>();
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    point2: for (int j = 0; j < n; j++) {
                        if (i == 0 && j < c) continue;
                        
                        Pair pair = new Pair(i, j);
                        for (Pair p: list) {
                            if (L1(p, pair) < d) {
                                continue point2;
                            }
                        }
                        
                        if (++cnt >= max) {
                            answer = d;
                            break point1;
                        }
                        list.add(pair);
                    }
                }
            }
        }
        
        System.out.println(max);
        return answer;
    }
    
    private class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}