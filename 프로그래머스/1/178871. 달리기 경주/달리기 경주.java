import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private void change(String[] players, String calling) {
        int index = map.get(calling);
        String temp = players[index - 1];
        players[index - 1] = calling;
        players[index] = temp;
        map.put(players[index - 1], index - 1);
        map.put(players[index], index);
    }
    
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
            
        for (int i = 0; i < len; i++) {
            map.put(players[i], i);
        }
        
        for (String calling: callings) {
            change(players, calling);
        }
        
        return players;
    }
}