import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    private final int start = 9 * 60;
    private int getTime(String time) {
        String[] splited = time.split(":");
        int h = Integer.parseInt(splited[0]);
        int m = Integer.parseInt(splited[1]);
        
        return h * 60 + m;
    }
    private String getStringTime(int time) {
        int h = time / 60;
        int m = time % 60;
        String H = String.format("%02d:", h);
        String M = String.format("%02d", m);
        return H + M;
    }
    private int getMax(ArrayList<Integer> list) {
        int max = 0;
        for (int i: list) {
            max = Math.max(max, i);
        }
        
        return max;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            times[i] = getTime(timetable[i]);
        }
        Arrays.sort(times);
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int temp = start;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            map.put(temp, new ArrayList<>());
            int cnt = 0;
            while (cnt < m && idx < len) {
                if (times[idx] <= temp) {
                    map.get(temp).add(times[idx++]);
                    cnt++;
                } else {
                    break;
                }
            }
            temp += t;
        }
        
        String answer = "";
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        if (map.get(keySet.get(n - 1)).size() < m) {
            answer = getStringTime(keySet.get(n - 1));
            return answer;
        }
        
        ArrayList<Integer> totalList = new ArrayList<>();
        for (int key: keySet) {
            for (int num: map.get(key)) {
                totalList.add(num);
            }
        }
        answer = getStringTime(getMax(totalList) - 1);
        
        return answer;
    }
}