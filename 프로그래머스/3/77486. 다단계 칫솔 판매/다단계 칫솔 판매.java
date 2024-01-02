import java.util.HashMap;

class Solution {
    private int[] answer;
    private int[] referralInt;
    private void dfs(int idx, int money) {
        if (idx == -1 || money == 0) {
            return;
        }
        
        answer[idx] += money - money / 10;
        dfs(referralInt[idx], money / 10);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        answer = new int[len];
        referralInt = new int[len];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(enroll[i], i);
        }
        for (int i = 0; i < len; i++) {
            referralInt[i] = map.getOrDefault(referral[i], -1);           
        }
        for (int i = 0; i < seller.length; i++) {
            dfs(map.get(seller[i]), amount[i] * 100);
        }
        
        return answer;
    }
}