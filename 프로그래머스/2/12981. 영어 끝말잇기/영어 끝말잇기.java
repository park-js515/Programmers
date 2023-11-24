import java.util.*;

class Solution {
    private static boolean sameEndStart(String end, String start) {
        int len = end.length();
        return end.charAt(len - 1) == start.charAt(0);
    }
    
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        
        int[] answer = {0, 0};
        for (int i = 1; i < words.length; i++) {
            if (!sameEndStart(words[i - 1], words[i]) || set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } else {
                set.add(words[i]);
            }
        }
        
        return answer;
    }
}