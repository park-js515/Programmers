import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        from.add(5);
        
        while (!from.isEmpty()) {
            for (int i : from) {
                answer.add(i);
                int next1 = i * 10;
                int next2 = i * 10 + 5;
                if (next1 <= r) to.add(next1);
                if (next2 <= r) to.add(next2);
            }
            from = to;
            to = new ArrayList<>();
        }
        
        while (!answer.isEmpty() && answer.peek() < l) answer.poll();
        if (answer.size() == 0) return new int[] {-1};
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}