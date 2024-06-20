// 온도 하강
// 온도 유지
// 온도 상승
// 에어컨 끔
// Array로 표현하기 어려운 범위를 HashMap으로 품: 속도와 메모리 측면에서 손실 발생하나 유연함

import java.util.HashMap;
import java.util.Collections;

class Solution {
    private int temperature, t1, t2, a, b;
    
    private void init(int temperature, int t1, int t2, int a, int b) {
        this.temperature = temperature;
        this.t1 = t1;
        this.t2 = t2;
        this.a = a;
        this.b = b;
    }
    
    private int off(int temp) {
        if (temp < temperature) return temp + 1;
        if (temp > temperature) return temp - 1;
        return temp;
    }
    
    private int[][] getAction(int temp, int cost) {
        int[][] arr = new int[2][4];
        arr[0][0] = temp - 1;
        arr[0][1] = temp;
        arr[0][2] = temp + 1;
        arr[0][3] = off(temp);
        arr[1][0] = cost + a;
        arr[1][1] = cost + b;
        arr[1][2] = cost + a;
        arr[1][3] = cost;
        
        return arr;
    }
    
    private boolean checkCondition(int temp) {
        return temp >= t1 && temp <= t2;
    }
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        init(temperature, t1, t2, a, b);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(temperature, 0);
        
        for (int i = 1; i < onboard.length; i++) {
            boolean onboarding = onboard[i] == 1;
            HashMap<Integer, Integer> nextMap = new HashMap<>();
            for (int k: map.keySet()) {
                int v = map.get(k);
                int[][] action = getAction(k, v);
                
                for (int j = 0; j < 4; j++) {
                    int dt = action[0][j];
                    int dc = action[1][j];
                    
                    if (onboarding && !checkCondition(dt)) continue;
                    nextMap.put(dt, Math.min(nextMap.getOrDefault(dt, Integer.MAX_VALUE), dc));
                }
            }
            map = nextMap;
        }
        
        return Collections.min(map.values());
    }
}