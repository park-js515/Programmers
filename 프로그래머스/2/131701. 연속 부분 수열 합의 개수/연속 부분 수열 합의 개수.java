import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int len = elements.length;
        int[] column = new int[len * 2];
        for (int i = 0; i < len * 2; i++) {
            column[i] = elements[i % len];
        }
        
        for (int i = 0; i < len; i++) {
            int prefixedSum = 0;
            for (int j = i; j < i + len - 1; j++) {
                prefixedSum += column[j];
                set.add(prefixedSum);
            }
        }
        
        return set.size() + 1;
    }
}