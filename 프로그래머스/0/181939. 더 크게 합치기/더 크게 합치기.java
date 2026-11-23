class Solution {
    private int pint(String s) {
        return Integer.parseInt(s);
    }
    
    public int solution(int a, int b) {
        String sa = Integer.toString(a);
        String sb = Integer.toString(b);
        
        return Math.max(pint(sa + sb), pint(sb + sa));
    }
}