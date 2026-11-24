// 범위에 따른 실수 가능성
import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(5);
        
        while (!queue.isEmpty()){
            int val = queue.poll();
            if (val <= r) {
                list.add(val);
            } else {
                continue;
            }
            
            queue.add(val * 10);
            queue.add(val * 10 + 5);
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i : list) {
            if (i >= l) {
                answer.add(i);
            }
        }
        
        if (answer.size() == 0) return new int[] {-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}