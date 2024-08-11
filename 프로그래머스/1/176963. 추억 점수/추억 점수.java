import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map1.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            String[] p = photo[i];
            int res = 0;
            Map<String, Integer> map2 = new HashMap<>(); 
            for (String s: p) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
            }
            
            for (String s: map1.keySet()) {
                res += map1.get(s) * map2.getOrDefault(s, 0); 
            }
            
            answer[i] = res;
        }
        
        return answer;
    }
}