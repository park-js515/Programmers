class Solution {
    public int solution(int[] topping) {
        int len = topping.length;
        if (len == 0) return 0;
        int[] person1 = new int[10001];
        int[] person2 = new int[10001];
        int cnt1 = 0;
        int cnt2 = 0;
        
        int answer = 0;
        person1[topping[0]] = 1;
        cnt1++;
        for (int i = 1; i < len; i++) {
            if (person2[topping[i]]++ == 0) cnt2++;
        }
        if (cnt1 == cnt2) answer++;
        for (int i = 1; i < len; i++) {
            int nowTopping = topping[i];
            if (person1[nowTopping]++ == 0) {
                cnt1++;
            }
            if (--person2[nowTopping] == 0) {
                cnt2--;
            }
            if (cnt1 == cnt2) answer++;
        }
        
        return answer;
    }
}