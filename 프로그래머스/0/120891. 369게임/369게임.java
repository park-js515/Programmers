class Solution {
    public int solution(int order) {
        int answer = 0;
        while (order > 0) {
            int num = order % 10;
            answer += num % 3 == 0 && num != 0 ? 1 : 0;
            order /= 10;
        }
        
        return answer;
    }
}