class Solution {
    public int solution(int n, int m, int[] section) {
        int index = 0;
        int len = section.length;
        int answer = 0;
        
        while (index < len) {
            answer++;
            int val = section[index] + m - 1;
            while (index < len && section[index] <= val) {
                index++;
            }
        }
        
        return answer;
    }
}