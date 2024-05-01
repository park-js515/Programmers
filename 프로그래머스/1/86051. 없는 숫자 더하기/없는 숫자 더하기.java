class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        point: for (int i = 1; i < 10; i++) {
            for (int j: numbers) {
                if (i == j) continue point;
            }
            answer += i;
        }
        
        return answer;
    }
}