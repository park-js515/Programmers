import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String s) {
        HashSet<String> set = new HashSet<>();
        ArrayList<Tuple> list = new ArrayList<>();
        s = s.replace("},", " ");
        s = s.replace("{", "");
        s = s.replace("}", "");
        String[] rawData = s.split(" ");
        int len = rawData.length;
        
        for (int i = 0; i < len; i++) {
            String[] values = rawData[i].split(",");
            list.add(new Tuple(values));
        }
        
        Collections.sort(list);
        int[] answer = new int[len];
        int idx = 0;
        for (Tuple tuple: list) {
            for (String st: tuple.arr) {
                if (!set.contains(st)) {
                    answer[idx++] = Integer.parseInt(st);
                    set.add(st);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private static class Tuple implements Comparable<Tuple> {
        String[] arr;
        
        Tuple (String[] arr) {
            this.arr = arr;
        }
        
        @Override
        public int compareTo(Tuple o) {
            return this.arr.length - o.arr.length;
        }
    }
}