class Solution {
    public int solution(int hp) {
        int val, answer = 0;
        
        val = hp / 5;
        hp %= 5;
        answer += val;
        
        val = hp / 3;
        hp %= 3;
        answer += val;
        
        answer += hp;
        
        return answer;
    }
}