class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int mul = 1;
        for (int num: num_list) {
            sum += num;
            mul *= num;
        }
        
        return Math.pow(sum, 2) > mul ? 1 : 0;
    }
}