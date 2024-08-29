class Solution {
    public int solution(int a, int b) {
        boolean flag1 = a % 2 == 1;
        boolean flag2 = b % 2 == 1;
        
        return flag1 &&  flag2 ? a * a + b * b :
        flag1 || flag2 ? 2 * (a + b) :
        Math.abs(a - b);
    }
}