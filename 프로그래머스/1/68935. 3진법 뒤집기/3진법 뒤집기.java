class Solution {
    public int solution(int n) {
        int answer = Integer.valueOf(
            new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
        
        return answer;
    }
}