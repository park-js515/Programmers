class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        int cnt = 0;
        while (cnt < n) {
            answer++;
            cnt += slice; 
        }
        
        return answer;
    }
}