import java.util.*;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        List<Character> list = new ArrayList<>();
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                list.add(ch);
            }
        }
        
        char[] answer = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return new String(answer);
    }
}