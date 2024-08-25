class Solution {
    public int solution(int a, int b) {
        String s = Integer.toString(a) + Integer.toString(b);
        int c = Integer.parseInt(s);
        int d = 2 * a * b;
        
        if (c == d)  return c;
        return Math.max(c, d);
    }
}