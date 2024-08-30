class Solution {
    public String[] solution(String[] names) {
        int len = (names.length / 5) + (names.length % 5 > 0 ? 1 : 0);
        String[] answer = new String[len];
        
        int index = 0;
        for (int i = 0; i < names.length; i += 5) {
            answer[index++] = names[i];
        }
        
        return answer;
    }
}