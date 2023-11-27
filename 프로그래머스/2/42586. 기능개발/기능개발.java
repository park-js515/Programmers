import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] completeDate = new int[len];
        for (int i = 0; i < len; i++) {
            int leftProgress = 100 - progresses[i];
            int speed = speeds[i];
            int q = leftProgress / speed;
            if (leftProgress % speed != 0) {
                q++;
            };
            completeDate[i] = q;
        }
        
        for (int i = 1; i < len; i++) {
            completeDate[i] = Math.max(completeDate[i - 1], completeDate[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int nowValue = completeDate[0];
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (nowValue == completeDate[i]) {
                cnt++;
            } else {
                list.add(cnt);
                nowValue = completeDate[i];
                cnt = 1;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}