class Solution {
    public int solution(int n) {
        int answer = 1;
        int val = 1;
        
        while (val < n) {
            val *= ++answer;
        }
        
        if (val != n) answer--;
        return answer;
    }
}