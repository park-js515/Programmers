class Solution {
    private final String[] B = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        point1 : for (String b : babbling) {
            int len = b.length();
            int index = 0;
            
            point2 : while (index < len) {
                for (int i = 0; i < 4; i++) {
                    if (b.startsWith(B[i], index)) {
                        index += B[i].length();
                        continue point2;
                    }
                }
                continue point1;
            }
            
            answer++;
        }
        
        return answer;
    }
}