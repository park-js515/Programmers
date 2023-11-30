import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int mapSize = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(Character.toString((char) i), ++mapSize);
        }
        
        int len = msg.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(msg.charAt(i));
            String st = sb.toString();
            if (!map.containsKey(st)) {
                map.put(st, ++mapSize);
                list.add(map.get(st.substring(0, st.length() - 1)));
                sb = new StringBuilder(st.substring(st.length() - 1));
            }
        }
    
        String st = sb.toString();
        if (map.containsKey(st)) {
            list.add(map.get(st));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}