class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String pat = Integer.toString(k);
        for (int x = i; x <= j; x++) {
            String s = Integer.toString(x);
            int index = 0;
            while (s.indexOf(pat, index) != -1) {
                answer++;
                index = s.indexOf(pat, index) + 1;
            }
        }
        
        return answer;
    }
}