class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int n = numer1 * denom2 + numer2 * denom1;
        int d = denom1 * denom2;
        int g = gcd(n, d);
        n /= g;
        d /= g;
        
        return new int[] {n, d};
    }
}