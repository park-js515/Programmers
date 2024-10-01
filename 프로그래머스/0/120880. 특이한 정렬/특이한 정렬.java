import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i : numlist) list.add(i);
        Collections.sort(list, (o1, o2) -> {
            int abs1 = Math.abs(o1 - n);
            int abs2 = Math.abs(o2 - n);
            
            if (abs1 == abs2) {
                return Integer.compare(o2, o1);
            } else {
                return Integer.compare(abs1, abs2);
            }
        });
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}