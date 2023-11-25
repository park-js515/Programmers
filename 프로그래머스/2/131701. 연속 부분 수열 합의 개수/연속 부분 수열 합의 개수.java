import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int len = elements.length;
        int[] column = new int[len * 2];
        for (int i = 0; i < len; i++) {
            column[i] = elements[i];
        }
        for (int i = len; i < 2 * len; i++) {
            column[i] = elements[i - len];
        }
        
        for (int i = 0; i < len; i++) {
            int prefixedSum = 0;
            for (int j = i; j < i + len - 1; j++) {
                prefixedSum += column[j];
                set.add(prefixedSum);
            }
        }
        
        // 아무것도 빼지 않았을 때의 경우 1
        return set.size() + 1;
    }
}