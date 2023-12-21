class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public long solution(int w, int h) {
        long total = (long)w * h;
        long G = gcd(w, h);
        long gH = h / G;
        long gW = w / G;
        long part = gH + gW - 1;
        
        return total - G * part;
    }
}