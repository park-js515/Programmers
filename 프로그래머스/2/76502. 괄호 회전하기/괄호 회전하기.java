import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    private static HashMap<Character, Character> map = new HashMap<>();
    private static boolean isComplete(int n, String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int stackSize = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (stackSize > 0 && map.getOrDefault(stack.peekLast(), 'N') == ch) {
                stackSize--;
                stack.pollLast();
            } else {
                stackSize++;
                stack.add(ch);
            }
        }
        
        if (stackSize > 0) return false;
        return true;
    }
    
    public int solution(String s) {
        char[][] brackets = {{'(', ')'}, {'{', '}'}, {'[', ']'}};
        for (char[] bracket: brackets) {
            map.put(bracket[0], bracket[1]);
        }
        int answer = 0;
        int len = s.length();
        if (isComplete(len, s)) answer++;
        for (int i = 0; i < len - 1; i++) {
            s = s.substring(1) + s.charAt(0);
            if (isComplete(len, s)) answer++;
        }
        
        return answer;
    }
}