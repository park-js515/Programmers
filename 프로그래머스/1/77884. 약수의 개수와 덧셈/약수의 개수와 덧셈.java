class Solution {
    private int solve(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        
        return cnt % 2 == 0 ? n : -n;
    }
    
    public int solution(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += solve(i);
        }
        
        return sum;
    }
}