// diff, time_cur, time_prev, level
// 이진탐색 + 하한을 구해야...

class Solution {
    private int[] diffs;
    private int[] times;
    private long limit;
    private int n;
    
    private void init(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        this.n = diffs.length;
    }
    
    private long getTime(int level) {
        long sum = 0;
        int time_prev = 0;
        for (int i = 0; i < n; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            
            if (diff <= level) {
                sum += time_cur;
            } else {
                long gap = diff - level;
                sum += gap * (time_prev + time_cur) + time_cur;
            }
            time_prev = time_cur;
        }
        
        return sum;
    }
    
    private int getLowerBound() {
        int left = 1;
        int right = Integer.MAX_VALUE;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            long time = getTime(mid);
            if (time > limit) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        init(diffs, times, limit);
        int answer = getLowerBound();
        return answer;
    }
}