// https://yabmoons.tistory.com/714
// 시간을 정해놓고, 그 시간내에 필요한 금과 은을 모두 운반할 수 있는지?
// 이분탐색 LowerBound 찾기 (가장 빠른 시간)

class Solution {
    private final long MAX = (long) (4 * 10e14 + 10e5); // 4 * 10^14 + 10^ 5;
    
    private boolean check(int n, int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long totalMineral = 0;
        long totalGold = 0;
        long totalSilver = 0;
        
        for (int i = 0; i < n; i++) {
            long cnt = (time / (2 * t[i]));
            if (time % (2 * t[i]) >= t[i]) cnt++;
            
            long temp = Math.min(cnt * w[i], g[i] + s[i]);
            totalMineral += Math.min(temp, g[i] + s[i]);
            totalGold += Math.min(temp, g[i]);
            totalSilver += Math.min(temp, s[i]);
        }
        
        if (totalMineral >= a + b && totalGold >= a && totalSilver >= b) {
            System.out.println(true);
            return true;
        }
        
        System.out.println(false);
        return false;
    }
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 1, right = MAX;
        int n = g.length;
        
        while (left + 1 < right) {
            long m = (left + right) / 2;
            if (check(n, a, b, g, s, w, t, m)) {
                right = m;
            } else {
                left = m;
            }
        }
        
        return right;
    }
}