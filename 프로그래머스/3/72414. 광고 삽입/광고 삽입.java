class Solution {
    private int getInt(String time) {
        String[] splited = time.split(":");
        int h = Integer.parseInt(splited[0]) * 3600;
        int m = Integer.parseInt(splited[1]) * 60;
        int s = Integer.parseInt(splited[2]);
        
        return h + m + s;
    }
    
    private String getString(int time) {
        String h = String.format("%02d", time / 3600);
        time %= 3600;
        String m = String.format("%02d", time / 60);
        time %= 60;
        String s = String.format("%02d", time);
        
        return h + ":" + m + ":" + s;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int pt = getInt(play_time);
        int at = getInt(adv_time);
        
        int[] interval = new int[pt + 1];
        long[] prefixed = new long[pt + 1];
        for (String log: logs) {
            String[] splited = log.split("-");
            int s = getInt(splited[0]);
            int e = getInt(splited[1]);
            interval[s]++;
            interval[e]--;
        }
        
        int val = interval[0];
        for (int i = 1; i <= pt; i++) {
            prefixed[i] += val + prefixed[i - 1];
            val += interval[i];
        }
        
        String answer = "";
        long max = 0;
        for (int i = 0; i <= pt; i++) {
            if (i + at <= pt) {
                if (prefixed[i + at] - prefixed[i] > max) {
                    max = prefixed[i + at] - prefixed[i];
                    answer = getString(i);
                }
            } else {
                break;
            }
        }
        
        return answer;
    }
}