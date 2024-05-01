class Solution {
    private long sum(int a) {
        long x = a;
        return x * (x + 1) / 2;
    }
    
    public long solution(int a, int b) {
        if (a == b) {
            return a;
        }
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        return sum(b) - sum(a) + a;
    }
}