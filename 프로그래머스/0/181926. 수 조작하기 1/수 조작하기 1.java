import java.util.Map;

class Solution {
    public int solution(int n, String control) {
        Map<Character, Integer> map = Map.of(
            'w', 1,
            's', -1,
            'd', 10,
            'a', -10
        );
        
        for (int i = 0; i < control.length(); i++) {
            n += map.get(control.charAt(i));
        }
        
        return n;
    }
}