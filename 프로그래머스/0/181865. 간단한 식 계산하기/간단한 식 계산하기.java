class Solution {
    public int solution(String binomial) {
        String[] input = binomial.split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[2]);
        int answer = 0;
        
        if (input[1].equals("+")) {
            answer = a + b;    
        } else if (input[1].equals("-")) {
            answer = a - b;
        } else {
            answer = a * b;
        }

        return answer;
    }
}