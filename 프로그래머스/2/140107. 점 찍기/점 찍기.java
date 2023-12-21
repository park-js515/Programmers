class Solution {
    private long findPoint(long base, long k, long d) {
        long ret = (long)Math.sqrt(d * d - base * base);
        return ret / k + 1;
    }
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            answer += findPoint(i, k, d);
        }
        
        return answer;
    }
}