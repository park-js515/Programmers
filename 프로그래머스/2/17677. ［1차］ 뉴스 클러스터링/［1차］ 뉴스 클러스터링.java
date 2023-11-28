import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        point1: for (int i = 0; i < str1.length() - 1; i++) {
            String st = str1.substring(i, i + 2);
            for (int j = 0; j < 2; j++) {
                char ch = st.charAt(j);
                if (ch < 'a' || ch > 'z') continue point1;
            }
            map1.put(st, map1.getOrDefault(st, 0) + 1);
        }
        point2: for (int i = 0; i < str2.length() - 1; i++) {
            String st = str2.substring(i, i + 2);
            for (int j = 0; j < 2; j++) {
                char ch = st.charAt(j);
                if (ch < 'a' || ch > 'z') continue point2;
            }
            map2.put(st, map2.getOrDefault(st, 0) + 1);
        }
        
        int numerator = 0;
        int denominator = 0;
        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) {
                numerator += Math.min(map1.get(key), map2.get(key));
                denominator += Math.max(map1.get(key), map2.get(key));
            } else {
                denominator += map1.get(key);
            }
        }
        for (String key: map2.keySet()) {
            if (!map1.containsKey(key)) {
                denominator += map2.get(key);
            }            
        }
        
        if (numerator == 0 && denominator == 0) return 65536;
        float jacard = (float) numerator / denominator;
        int answer = (int)(jacard * 65536);
        return answer;
    }
}