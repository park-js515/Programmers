import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] skipChar = skip.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch: skipChar) {
            set.add(ch);
        }
        
        char[] sChar = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (char ch: sChar) {
            char copy = ch;
            if (map.containsKey(ch)) continue;
            for (int i = 0; i < index; i++) {
                copy = (char) (copy + 1);
                while (set.contains(copy)) {
                    copy = (char) (copy + 1);
                }
                if (copy > 'z') {
                    copy = 'a';
                    while (set.contains(copy)) {
                    copy = (char) (copy + 1);
                    }
                }
            }
            map.put(ch, copy);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch: sChar) {
            sb.append(map.get(ch));
        }
        
        return sb.toString();
    }
}