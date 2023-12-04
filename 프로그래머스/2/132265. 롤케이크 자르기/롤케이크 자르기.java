import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> map1 = new HashMap<>();        
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int len = topping.length;
        if (len == 1) return 0;
        
        int answer = 0;
        map1.put(topping[0], 1);
        for (int i = 1; i < len; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }
        if (map1.size() == map2.size()) answer++;
        
        for (int i = 1; i < len; i++) {
            map1.put(topping[i], map1.getOrDefault(topping[i], 0) + 1);
            map2.put(topping[i], map2.get(topping[i]) - 1);
            if (map2.get(topping[i]) == 0) {
                map2.remove(topping[i]);
            }
            if (map1.size() == map2.size()) answer++;
        }
    
        return answer;
    }
}