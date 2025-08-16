import java.util.*;


class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String c = cloth[0];
            String t = cloth[1];
            
            map.computeIfAbsent(t, key -> new HashSet<String>()).add(c);
        }
        
        int answer = 1;
        for (String k : map.keySet()) {
            answer *= (map.get(k).size() + 1);
        }
        
        return answer - 1;
    }
}