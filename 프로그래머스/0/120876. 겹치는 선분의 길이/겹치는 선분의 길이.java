class Solution {
    public int solution(int[][] lines) {
        int[] bucket = new int[201];
        for (int[] line : lines) {
            bucket[line[0] + 100]++;
            bucket[line[1] + 100]--;
        }
        
        int answer = 0;
        int cnt = bucket[0];
        for (int i = 1; i <= 200; i++) {
            if (cnt > 1) {
                answer++;
            }
            cnt += bucket[i];
        }
        
        return answer;
    }
}