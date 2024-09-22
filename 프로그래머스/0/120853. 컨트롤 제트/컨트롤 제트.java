import java.util.*;

class Solution {
    public int solution(String s) {
        String[] split = s.split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        for (String str : split) {
            if (str.equals("Z")) {
                stack.pollLast();
            } else {
                stack.add(str);
            }
        }
        
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += Integer.parseInt(stack.pollLast());
        }
        
        return answer;
    }
}