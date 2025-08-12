import java.util.*;

class Solution {
    private int getCount(int progress, int speed) {
        double a = 100 - progress;
        double b = a / speed;
        double c = Math.ceil(b);
        
        return (int) c;
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            arr[i] = getCount(progress, speed);
        }
        
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();        
        int num = arr[0];
        int cnt = 1;
        
        for (int i = 1; i < n; i++) {
            int nextNum = arr[i];
            
            if (num != nextNum) {
                list.add(cnt);
                cnt = 1;
                num = nextNum;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}