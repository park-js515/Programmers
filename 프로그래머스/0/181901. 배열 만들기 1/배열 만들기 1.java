class Solution {
    public int[] solution(int n, int k) {
        int c = n / k;
        int idx = 0;
        int[] answer = new int[c];
        
        for (int i = k; i <= n; i += k) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}