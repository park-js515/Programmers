import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs) {
            int a = Integer.parseInt(str.substring(s, s + l));
            if (a > k) {
                list.add(a);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}