class Solution {
    private boolean check(int[] sides, int num) {
        int sum = num;
        int max = num;
        
        for (int side : sides) {
            sum += side;
            max = Math.max(max, side);
        }
        
        return sum - max > max;
    }
    
    public int solution(int[] sides) {
        int answer = 0;
        for (int i = 1; i < sides[0] + sides[1]; i++) {
            if (check(sides, i)) answer++;
        }
        
        return answer;
    }
}