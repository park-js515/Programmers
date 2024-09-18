import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < before.length(); i++) {
            char ch1 = before.charAt(i);
            char ch2 = after.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }
        
        if (map1.equals(map2)) return 1;
        return 0;
    }
}