// 다익스트라? DP
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
        private final int[][] ARR = {
        {1, 1},
        {2, 1},
        {3, 1},
        {4, 1},
        {5, 1},
        {6, 1},
        {7, 1}, {21, 0},
        {8, 1}, {24, 0},
        {9, 1}, {27, 0},
        {10, 1}, {30, 0},
        {11, 1}, {22, 0}, {33, 0},
        {12, 1}, {24, 0}, {36, 0},
        {13, 1}, {26, 0}, {39, 0},
        {14, 1}, {28, 0}, {42, 0},
        {15, 1}, {45, 0},
        {16, 1}, {32, 0}, {48, 0},
        {17, 1}, {34, 0}, {51, 0},
        {18, 1}, {54, 0},
        {19, 1}, {38, 0}, {57, 0},
        {20, 1}, {40, 0}, {60, 0},
        {50, 1}
    };
    
    public int[] solution(int target) {
        int[][] DP = new int[target + 1][2];
        for (int i = 0; i < target + 1; i++) {
            DP[i][0] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o2[2] - o1[2];
        });
        pq.add(new int[] {0, 0, 0});
        while (!pq.isEmpty() && DP[target][0] == Integer.MAX_VALUE) {
            int[] now = pq.poll();
            int index = now[0];
            int dist = now[1];
            int cost = now[2];
            
            if (DP[index][0] > dist) {
                DP[index][0] = dist;
                DP[index][1] = cost;
            } else if (DP[index][0] == dist && DP[index][1] < cost) {
                DP[index][1] = cost;
            } else {
                continue;
            }
            DP[index][0] = dist;
            DP[index][1] = cost;
            
            for (int[] a: ARR) {
                int nextIndex = index + a[0];
                int nextDist = dist + 1;
                int nextCost = cost + a[1];
                if (nextIndex > target) {
                    continue;
                }
                if (DP[nextIndex][0] > nextDist) {
                    pq.add(new int[] {nextIndex, nextDist, nextCost});
                } else if (DP[nextIndex][0] == nextDist && DP[nextIndex][1] < nextCost) {
                    pq.add(new int[] {nextIndex, nextDist, nextCost});
                }
            }
        }
        
        return new int[] {DP[target][0], DP[target][1]};
    }
}