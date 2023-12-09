import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (k > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                while (k > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                    k--;
                    stack.pop();
                }
            }
            stack.push(number.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        for (char ch: stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}