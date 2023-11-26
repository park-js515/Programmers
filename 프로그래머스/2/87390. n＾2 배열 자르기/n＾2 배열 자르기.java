class Solution {
    // 타입 에러 해결이 문제
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            answer[idx++] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}