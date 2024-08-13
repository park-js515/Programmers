import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('R', 0);
            put('T', 0);
            put('C', 0);
            put('F', 0);
            put('J', 0);
            put('M', 0);
            put('A', 0);
            put('N', 0);
        }};
        
        int len = choices.length;
        for (int i = 0; i < len; i++) {
            char l = survey[i].charAt(0);
            char r = survey[i].charAt(1);
            int score = choices[i] - 4;
            if (score > 0) {
                map.put(r, map.get(r) + score);
            } else {
                map.put(l, map.get(l) - score);
            }
        }
        
        char[][] mbti = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char l = mbti[i][0];
            char r = mbti[i][1];
            int scoreL = map.get(l);
            int scoreR = map.get(r);
            if (scoreL >= scoreR) {
                sb.append(l);
            } else {
                sb.append(r);
            }
        }        
        
        return sb.toString();
    }
}