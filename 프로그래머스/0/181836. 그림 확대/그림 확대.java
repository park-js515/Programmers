class Solution {
    public String[] solution(String[] picture, int k) {
        int r = picture.length;
        int c = picture[0].length();
        int len = r * k;
        StringBuilder[] sbMatrix = new StringBuilder[len];
        for (int i = 0; i < len; i++) {
            sbMatrix[i] = new StringBuilder();
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = picture[i].charAt(j);
                for (int a = 0; a < k; a++) {
                    for (int b = 0; b < k; b++) {
                        sbMatrix[i * k + a].append(ch);
                    }
                }
            }
        }
        
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = sbMatrix[i].toString();
        }
        
        return answer;
    }
}