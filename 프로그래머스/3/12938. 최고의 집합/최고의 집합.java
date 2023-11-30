class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1};
        int[] answer = new int[n];
        int val = s / n;
        s -= val * n;
        for (int i = 0; i < n; i++) {
            answer[i] = val;
        }
        for (int i = 0; i < s; i++) {
            answer[n - 1 - (i % n)]++;            
        }
        return answer;
    }
}