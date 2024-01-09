import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayDeque<Assignment> list = new ArrayDeque<>();
        PriorityQueue<Assignment> pq = new PriorityQueue<>();
        
        for (String[] plan: plans) {
            pq.add(new Assignment(plan[0], plan[1], plan[2]));
        }
        
        int now = 0;
        while (!pq.isEmpty()) {
            if (list.isEmpty()) {
                Assignment assignment = pq.poll();
                now = assignment.time;
                list.add(assignment);
            } else {
                Assignment assignment = pq.poll();
                int gap = assignment.time - now;
                while (!list.isEmpty() && gap > 0) {
                    if (list.peek().duration <= gap) {
                        gap -= list.peek().duration;
                        answer.add(list.poll().subject);
                    } else {
                        list.peek().duration -= gap;
                        break;
                    }
                }
                list.addFirst(assignment);
                now = assignment.time;
            }
        }
        while (!list.isEmpty()) {
            answer.add(list.poll().subject);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private class Assignment implements Comparable<Assignment> {
        String subject;
        int time, duration;
        
        public Assignment(String subject, String time, String duration) {
            this.subject = subject;
            String[] splited = time.split(":");
            this.time = Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
            this.duration = Integer.parseInt(duration);
        }
        
        @Override
        public int compareTo(Assignment o) {
            return this.time - o.time;
        }
    }
}