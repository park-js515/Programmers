import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        
        ArrayDeque<Item> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int i = 0; i < n; i++) {
            int p = priorities[i];
            queue.add(new Item(p, i));
            pq.add(p);
        }
        
        int answer = 1;
        int val = pq.poll();
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            
            if (val == item.p) {
                if (location == item.l) {
                    break;
                }
                val = pq.poll();
                answer++;
            } else {
                queue.add(item);
            }
        }
        
        return answer;
    }
    
    private class Item {
        int p, l;
        
        public Item(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
}