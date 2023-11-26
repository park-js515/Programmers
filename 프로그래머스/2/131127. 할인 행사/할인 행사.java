import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        int wantLen = want.length;
        int discountLen = discount.length;
        
        int left = 0;
        int right = 0;
        int date = -1;
        int answer = 0;
        
        while (left < discountLen) {
            date++;
            if (right < discountLen) {
                map.put(discount[right], map.getOrDefault(discount[right++], 0) + 1);
            }
            if (date - left == 10) {
                map.put(discount[left], map.get(discount[left++]) - 1);            
            }
            
            boolean satisfied = true;
            for (int i = 0; i < wantLen; i++) {
                if (map.getOrDefault(want[i], 0) < number[i]) {
                    satisfied = false;
                    break;
                }
            }
            if (satisfied) answer++;
        }
        
        return answer;
    }
}