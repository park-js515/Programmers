import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == ')' && stack.peekLast() == '(') {
                stack.pollLast();
            } else {
                stack.add(ch);
            }
        }
        
        while (stack.size() >= 2) {
            char right = stack.pollLast();
            char left = stack.pollLast();
            
            if (left == '(' && right == ')') {
                continue;
            } else {
                return false;
            }
        }
        
        return stack.size() == 0;
    }
}