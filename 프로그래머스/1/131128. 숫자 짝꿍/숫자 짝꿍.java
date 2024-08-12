import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map3 = new HashMap<>();
        List<Character> list = new ArrayList<>();
        
        for (int i = 0; i < X.length(); i++) {
            char ch = X.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < Y.length(); i++) {
            char ch = Y.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch: map1.keySet()) {
            if (!map2.containsKey(ch)) continue;
            for (int i = 0; i < Math.min(map1.get(ch), map2.get(ch)); i++) {
                list.add(ch);
            }
        }
        
        if (list.size() == 0) return "-1";
        
        Collections.sort(list, Collections.reverseOrder());
        if (list.get(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (char ch: list) sb.append(ch);
        return sb.toString();
    }
}