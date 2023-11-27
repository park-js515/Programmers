import java.util.PriorityQueue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Item> pq = new PriorityQueue<>();
        ArrayDeque<Item> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            if (i != location) {
                queue.add(new Item(priorities[i], false));   
            } else {
                queue.add(new Item(priorities[i], true));
            }
            pq.add(new Item(priorities[i], false));
        }
        
        int idx = 0;
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.priority != pq.peek().priority) {
                queue.add(item);
            } else {
                idx++;
                pq.poll();
                if (item.target) {
                    return idx;
                }
            }
        }
        
        return idx;
    }
    
    private static class Item implements Comparable<Item> {
        int priority;
        boolean target;
        
        Item (int priority, boolean target) {
            this.priority = priority;
            this.target = target;
        }
        
        @Override
        public int compareTo(Item o) {
            return o.priority - this.priority;
        }
    }
}