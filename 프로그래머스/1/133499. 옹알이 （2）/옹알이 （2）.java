class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        int[] len = {3, 2, 3, 2};
        int answer = 0;
        
        point1: for (String b: babbling) {
            int index = 0;
            int last = -1;
            int bLen = b.length();
            
            point2: while (index < bLen) {
                for (int i = 0; i < 4; i++) {
                    if (i == last) continue;
                    if (b.startsWith(arr[i], index)) {
                        index += len[i];
                        last = i;
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