class Solution {
    public int[] solution(String s) {
        int[] bucket = new int[200];
        int len = s.length();
        
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int idx = (int) s.charAt(i);
            
            if (bucket[idx] == 0) {
                answer[i] = -1;
            } else {
                answer[i] = i - bucket[idx] + 1;
            }
            
            bucket[idx] = i + 1;
        }
        
        return answer;
    }
}