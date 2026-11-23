class Solution {
    private int pint(String s) {
        return Integer.parseInt(s);
    }
    
    public int solution(int a, int b) {
        return Math.max(pint(Integer.toString(a) + Integer.toString(b)), 2 * a * b);
    }
}