class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        for (int a : array) {
            int gap1 = Math.abs(a - n);
            int gap2 = Math.abs(answer - n);
            if (gap1 < gap2) {
                answer = a;
            } else if (gap1 == gap2) {
                answer = Math.min(answer, a);
            }
        }
        
        return answer;
    }
}