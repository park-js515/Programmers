import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for (String s: keymap) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, Math.min(map.getOrDefault(ch, 100), i + 1));
            }
        }
        
        int[] answer = new int[targets.length];
        point: for (int i = 0; i < targets.length; i++) {
            int cost = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if (!map.containsKey(ch)) {
                    answer[i] = -1;
                    continue point;
                }
                cost += map.get(ch);
            }
            answer[i] = cost;
        }
        
        return answer;
    }
}