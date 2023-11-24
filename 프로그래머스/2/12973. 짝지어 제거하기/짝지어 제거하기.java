import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (stackSize >= 1 && stack.peekLast() == ch) {
                stackSize--;
                stack.pollLast();
            } else {
                stackSize++;
                stack.add(ch);
            }
        }
        
        if (stackSize > 0) return 0;
        return 1;
    }
}