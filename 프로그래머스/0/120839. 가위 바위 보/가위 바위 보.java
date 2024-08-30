import java.util.Map;

class Solution {
    public String solution(String rsp) {
        Map<Character, Character> map = Map.of(
            '2', '0',
            '0', '5',
            '5', '2'
        );
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rsp.length(); i++) {
            sb.append(map.get(rsp.charAt(i)));
        }
        
        return sb.toString();
    }
}