import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int total = 0;
        ArrayDeque<Truck> queue = new ArrayDeque<>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            if (!queue.isEmpty() && queue.peek().t + bridge_length < time) {
                total -= queue.poll().w;
            }
            
            int w = truck_weights[i];
            while (total + w > weight) {
                Truck truck = queue.poll();
                total -= truck.w;
                time = truck.t + bridge_length;
            }
            
            queue.add(new Truck(w, time));
            total += w;
            time++;
        }
        
        return queue.peekLast().t + bridge_length;
    }
    
    private class Truck {
        int w, t;
        
        public Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }
        
        @Override
        public String toString() {
            return "[w = " + w + ", t = " + t + "]";
        }
    }
}