class Solution {
    public int solution(String my_string) {
        String[] split = my_string.split(" ");
        int answer = Integer.parseInt(split[0]);
        
        for (int i = 1; i < split.length; i += 2) {
            if (split[i].equals("+")) {
                answer += Integer.parseInt(split[i + 1]);
            } else {
                answer -= Integer.parseInt(split[i + 1]);
            }
        }
        
        return answer;
    }
}