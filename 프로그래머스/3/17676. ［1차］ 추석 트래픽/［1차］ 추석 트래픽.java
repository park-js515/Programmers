import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;

class Solution {
    private int[] getTime(String st) {
        String[] splited1 = st.split(" ");
        String[] splited2 = splited1[1].split(":");
        String[] splited3 = splited2[2].split("\\.");
        int h = Integer.parseInt(splited2[0]) * 60 * 60 * 1000;
        int m = Integer.parseInt(splited2[1]) * 60 * 1000;
        int s = Integer.parseInt(splited3[0]) * 1000;
        int ms = Integer.parseInt(splited3[1]);
        int gap = (int) (Double.parseDouble(splited1[2].substring(0, splited1[2].length() - 1)) * 1000);
        
        int temp = h + m + s + ms;
        int[] time = new int[2];
        time[0] = temp - gap + 1;
        time[1] = temp;
        
        return time;
    }
    
    public int solution(String[] lines) {
        int len = lines.length;
        boolean[] visited = new boolean[len];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] time = getTime(lines[i]);
            list.add(new int[] {time[0], i, 1});
            list.add(new int[] {time[1], i, -1});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(list.get(0));
        int answer = 0;
        int in = 1;
        int out = 0;
        for (int i = 1; i < 2 * len; i++) {
            int[] now = list.get(i);
            int nowTime = now[0];
            int nowIndex = now[1];
            int nowType = now[2];
            
            while (!queue.isEmpty() && nowTime - queue.peek()[0] >= 1000) {
                int[] rm = queue.poll();
                if (rm[2] == -1 && !visited[rm[1]]) {
                    visited[rm[1]] = true;
                    out++;
                }
            }
            queue.add(list.get(i));
            if (nowType == 1) {
                in++;
            }
            
            answer = Math.max(answer, in - out);
        }
        
        return answer;
    }
}