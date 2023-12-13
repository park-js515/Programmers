import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    private String calc(String st1, String st2, String op) {
        long num1 = Long.parseLong(st1);
        long num2 = Long.parseLong(st2);
        long ret = 0;
        if (op.equals("+")) {
            ret = num1 + num2;
        } else if (op.equals("-")) {
            ret = num1 - num2;
        } else {
            ret = num1 * num2;
        }

        return Long.toString(ret);
    }
    
    private ArrayDeque<String> getSplited(String st) {
        ArrayDeque<String> splited = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else {
                splited.add(sb.toString());
                splited.add(Character.toString(ch));
                sb = new StringBuilder();
            }
        }
        splited.add(sb.toString());
        
        return splited;
    }
    
    public long solution(String expression) {
        String[][] orders = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
        };
        
        long answer = 0;
        for (int i = 0; i < 6; i++) {
            ArrayDeque<String> queue = getSplited(expression);
            String[] order = orders[i];
            for (String nowOrder: order) {
                ArrayDeque<String> stack = new ArrayDeque<>();
                while (!queue.isEmpty()) {
                    String now = queue.poll();
                    if (now.equals(nowOrder)) {
                        stack.add(calc(stack.pollLast(), queue.poll(), now));
                    } else {
                        stack.add(now);
                    }
                }
                
                if (stack.size() == 1) {
                    answer = Math.max(answer, Math.abs(Long.parseLong(stack.pollLast())));
                    break;
                } else {
                    queue = stack;
                }
            }
        }
        
        return answer;
    }
}