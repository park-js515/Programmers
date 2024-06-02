import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] ingredient) {
        if (ingredient.length < 4) return 0;
        
        ArrayList<Integer> pattern = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
        ArrayDeque<Integer> full = new ArrayDeque<>();
        ArrayDeque<Integer> part = new ArrayDeque<>();
        
        int answer = 0;
        ArrayList<Integer> temp;
        for (int i = 0; i < 4; i++) {
            part.add(ingredient[i]);
        }
        
        for (int i = 4; i < ingredient.length; i++) {
            if (part.size() == 4) {
                temp = new ArrayList<>(part);
                if (temp.equals(pattern)) {
                    answer++;
                    part.clear();
                    while (!full.isEmpty() && part.size() < 3) {
                        part.addFirst(full.pollLast());
                    }
                } else {
                    full.add(part.poll());
                }
            }
            
            part.add(ingredient[i]);
        }
        
        if (part.size() == 4) {
            temp = new ArrayList<>(part);
            if (temp.equals(pattern)) {
                answer++;
            }
        }
        
        return answer;
    }
}