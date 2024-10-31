class Solution {
    private int len, now, start, end;
    
    private int pint(String s) {
        return Integer.parseInt(s);
    }
    
    private int toInt(String time) {
        String[] splited =  time.split(":");
        return pint(splited[0]) * 60 + pint(splited[1]);
    }
    
    private String toTime(int s) {
        String h = String.format("%02d", s / 60);
        String m = String.format("%02d", s % 60);
        return h + ":" + m;
    }
    
    private void init(String video_len, String pos, String op_start, String op_end) {
        this.len = toInt(video_len);
        this.now = toInt(pos);
        this.start = toInt(op_start);
        this.end = toInt(op_end);
    }
    
    private void move(String command) {
        if (now >= start && now < end) {
            now = end;
        }
        
        if (command.equals("next")) {
            now += 10;
            now = Math.min(len, now);
        } else {
            now -= 10;
            now = Math.max(0, now);
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        init(video_len, pos, op_start, op_end);
        for (String command : commands) {
            move(command);
        }
        if (now >= start && now < end) {
            now = end;
        }
        
        return toTime(now);
    }
}