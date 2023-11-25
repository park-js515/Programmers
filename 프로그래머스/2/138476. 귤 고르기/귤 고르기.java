import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Item> list = new ArrayList<>();
        for (int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        for (int key: map.keySet()) {
            list.add(new Item(key, map.get(key)));
        }
        Collections.sort(list);
        
        int answer = 0;
        int counts = 0;
        for (Item item: list) {
            answer++;
            if (counts + item.cnt >= k) {
                return answer;
            } else {
                counts += item.cnt;
            }
        }
        
        return answer;
    }
    
    private static class Item implements Comparable<Item> {
        int size, cnt;

        Item(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }

        public int compareTo(Item o) {
            return o.cnt - this.cnt;
        }
    }
}