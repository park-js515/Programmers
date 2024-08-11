class Solution {
    public int solution(int number, int n, int m) {
        boolean flag1 = number % n == 0;
        boolean flag2 = number % m == 0;
        
        return flag1 && flag2 ? 1 : 0;
    }
}