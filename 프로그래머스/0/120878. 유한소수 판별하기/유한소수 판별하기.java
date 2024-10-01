class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public int solution(int a, int b) {
        int g = gcd(a, b);
        int target = b / g;
        
        while (target > 0 && target % 5 == 0) {
            target /= 5;
        }
        while (target > 0 && target % 2 == 0) {
            target /= 2;
        }
        
        return target == 1 ? 1 : 2;
    }
}