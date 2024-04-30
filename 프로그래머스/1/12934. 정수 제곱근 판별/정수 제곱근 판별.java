class Solution {
    public long solution(long n) {
        long s = (long) Math.sqrt(n);
        
        if (s * s == n) {
            return (s + 1) * (s + 1);
        }
        
        return -1;
    }
}