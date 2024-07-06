import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> list = new ArrayList<>();
        for (int s: score) {
            list.add(s);            
        }
        
        int answer = 0;
        Collections.sort(list, Collections.reverseOrder());
        int size = list.size();
        for (int i = 0; i < size / m; i++) {
            int min = list.get((i * m) + m - 1);
            answer += min * m;
        }
        
        return answer;
    }
}