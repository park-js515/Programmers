class Solution {
    private int op(int a, int b) {
        return Integer.parseInt(Integer.toString(a) + Integer.toString(b));
    }
    
    public int solution(int a, int b) {
        return Math.max(op(a, b), op(b, a));
    }
}