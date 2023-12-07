import java.util.Arrays;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        Arrays.sort(stations);
        int idx = 0;
        int len = stations.length;
        int now = 1;
        int range = w * 2 + 1;
        
        while (now <= n) {
            if (idx < len && stations[idx] - w <= now) {
                now = Math.max(now, stations[idx++] + w + 1);
            } else {
                now += range;
                answer++;
            }
        }
        
        return answer;
    }
}