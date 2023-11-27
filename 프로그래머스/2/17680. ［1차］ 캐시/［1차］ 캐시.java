import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (map.getOrDefault(city, 0) > 0) {
                answer++;
                queue.add(city);
                map.put(city, map.get(city) + 1);
            } else {
                answer += 5;
                
                queue.add(city);
                map.put(city, map.getOrDefault(city, 0) + 1);
                while (map.size() > cacheSize) {
                    String out = queue.poll();
                    map.put(out, map.get(out) - 1);                    
                    if (map.get(out) == 0) {
                        map.remove(out);
                    }
                }
            }
        }

        return answer;
    }
}