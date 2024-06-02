// 거리와 시간을 고려한 다익스트라
import java.util.PriorityQueue;


class Solution {
    private int m, n, s;
    private long[][][] visited;
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[] answer = new int[2];
    
    
    private void init(int m, int n, int s) {
        this.m = m;
        this.n = n;
        this.s = s;
        this.visited = new long[m][n][2];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = Long.MAX_VALUE;
                }
            }
        }
    }
    
    private void solve(int[][] time_map) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0, 0));
        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            long dist = visited[pair.r][pair.c][0];
            long time = visited[pair.r][pair.c][1];
            
            if (dist < pair.dist || (dist == pair.dist && time <= pair.time)) continue;
            visited[pair.r][pair.c][0] = pair.dist;
            visited[pair.r][pair.c][1] = pair.time;
            long nextDist = pair.dist + 1;
            
            for (int i = 0; i < 4; i++) {
                int dr = pair.r + d[i][0];
                int dc = pair.c + d[i][1];
                
                if (dr < 0 || dr >= m || dc < 0 || dc >= n || time_map[dr][dc] == -1) continue;
                
                long nextTime = pair.time + time_map[dr][dc];
                if (nextTime > s) continue;
                if (visited[dr][dc][0] < nextDist || 
                    (visited[dr][dc][1] == nextDist && visited[dr][dc][1] <= nextTime)) continue;
                
                pq.add(new Pair(dr, dc, nextDist, nextTime)); 
            }
        }
        
        answer[0] = (int) visited[m - 1][n - 1][0];
        answer[1] = (int) visited[m - 1][n - 1][1];
    }
    
    public int[] solution(int m, int n, int s, int[][] time_map) {
        init(m, n, s);
        solve(time_map);
      
        return answer;
    }
    
    private class Pair implements Comparable<Pair> {
        int r, c;
        long dist, time;
        
        public Pair(int r, int c, long dist, long time) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.time = time;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.dist != o.dist) {
                Long.compare(this.dist, o.dist);
            }
            return Long.compare(this.time, o.time);
        }
    }
}