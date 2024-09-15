class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int index = 0;
        int len = pat.length();
        
        while (true) {
            int nextIndex = myString.indexOf(pat, index);
            if (nextIndex == -1) break;
            index = nextIndex + 1;
            answer++;
        }
        
        return answer;
    }
}