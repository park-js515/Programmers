class Solution {
    public int solution(int num) {
        int cnt = 0;
        long n = num;
        
        if (n == 1) return 0;
        
        while (++cnt <= 500) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n++;
            }
            
            if (n == 1) {
                return cnt;
            }
        }
        
        return -1;
    }
}