import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        int len = quiz.length;
        String[] answer = new String[len];
        
        for (int i = 0; i < len; i++) {
            String q = quiz[i];
            String[] split = q.split(" ");
            int num1 = Integer.parseInt(split[0]);
            String op = split[1];
            int num2 = Integer.parseInt(split[2]);
            int result = Integer.parseInt(split[4]);
            
            int val;
            if (op.equals("-")) {
                val = num1 - num2;
            } else {
                val = num1 + num2;
            }
            
            if (val == result) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        
        return answer;
    }
}