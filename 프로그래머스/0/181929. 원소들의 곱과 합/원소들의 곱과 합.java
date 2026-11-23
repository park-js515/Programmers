class Solution {
    public int solution(int[] num_list) {
        int t1 = 1;
        int t2 = 0;
        for (int i : num_list) {
            t1 *= i;
            t2 += i;
        }
        
        t2 *= t2;
        
        return t1 < t2 ? 1 : 0;
    }
}