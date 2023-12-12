import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    private int getMinute(String begin, String end) {
        String[] splited1 = begin.split(":");
        String[] splited2 = end.split(":");
        int h1 = Integer.parseInt(splited1[0]);
        int h2 = Integer.parseInt(splited2[0]);
        int m1 = Integer.parseInt(splited1[1]);
        int m2 = Integer.parseInt(splited2[1]);
        
        return (h2 - h1) * 60 + (m2 - m1);
    }
    
    public String solution(String m, String[] musicinfos) {
        ArrayList<String> scales = new ArrayList<>(Arrays.asList("C", "C#", "D", "D#", "E", "F", 
                                                                 "F#", "G", "G#", "A", "A#", "B"));
        int idx = 0;
        ArrayList<Music> answerList = new ArrayList<>();
        for (String musicinfo: musicinfos) {
            String[] splited = musicinfo.split(",");
            int minute = getMinute(splited[0], splited[1]);
            String name = splited[2];
            String melody = splited[3];
            int melodyLen = melody.length();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < melodyLen; i++) {
                if (i + 2 <= melodyLen && scales.contains(melody.substring(i, i + 2))) {
                    list.add(melody.substring(i, i + 2));
                    i++;
                } else {
                    list.add(melody.substring(i, i + 1));
                }
            }
        
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minute; i++) {
                sb.append(list.get(i % size));
            }
            
            int start = 0;
            String st = sb.toString();
            while (true) {
                int idx1 = st.indexOf(m, start);
                int idx2 = st.indexOf(m + "#", start);
                
                if (idx1 != -1 && idx1 != idx2) {
                    answerList.add(new Music(name, idx++, minute));
                    break;
                } else if (idx1 == -1) {
                    break;
                } else {
                    start = idx1 + 1;
                }
            }
        }
        
        if (answerList.size() > 0) {
            Collections.sort(answerList);
            return answerList.get(0).name;
        }
        return "(None)";
    }
    
    private class Music implements Comparable<Music> {
        String name;
        int idx, minute;
        
        Music(String name, int idx, int minute) {
            this.name = name;
            this.idx = idx;
            this. minute = minute;
        }
        
        @Override 
        public int compareTo(Music o) {
            if (this.minute != o.minute) {
                return o.minute - this.minute;
            }
            return this.idx - o.idx;
        }
    }
}