import java.util.Arrays;

class Solution {
    public int solution(String[] words) {
        int n = words.length;
        Arrays.sort(words);
        
        int[] arr = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int len = Math.min(words[i - 1].length(), words[i].length());
            for (int j = 0; j < len; j++) {
                if (words[i - 1].charAt(j) == words[i].charAt(j)) {
                    arr[i]++;
                } else {
                    break;                    
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.max(arr[i] + 1, Math.min(words[i].length(), arr[i + 1] + 1));
        }
        
        return answer;
    }
}