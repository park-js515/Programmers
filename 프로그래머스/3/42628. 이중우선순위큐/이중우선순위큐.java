import java.util.*;

class Solution {
    private int pint(String s) {
        return Integer.parseInt(s);
    }
    
    public int[] solution(String[] operations) {
        PriorityQueue<Item> maxQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.val, o1.val));
        PriorityQueue<Item> minQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        
        point : for (String op : operations) {
            String[] splited = op.split(" ");
            char comm = splited[0].charAt(0);
            int num = pint(splited[1]);
            
            if (comm == 'I') {
                Item item = new Item(num);
                maxQ.add(item);
                minQ.add(item);
            } else {
                PriorityQueue<Item> queue;
                
                if (num == 1) {
                    queue = maxQ;
                } else {
                    queue = minQ;
                }
                
                while (!queue.isEmpty()) {
                    Item current = queue.poll();
                    if (!current.deleted) {
                        current.deleted = true;
                        continue point;
                    }
                }
            }
        }
        
        int[] answer = {0, 0};
        while (!maxQ.isEmpty() && maxQ.peek().deleted) {
            maxQ.poll();
        }
        while (!minQ.isEmpty() && minQ.peek().deleted) {
            minQ.poll();
        }
        if (!maxQ.isEmpty()) {
            answer[0] = maxQ.peek().val;
        }
        if (!minQ.isEmpty()) {
            answer[1] = minQ.peek().val;
        }
        
        return answer;
    }
    
    private class Item {
        int val;
        boolean deleted;
        
        public Item(int val) {
            this.val = val;
            deleted = false;
        }
    }
}