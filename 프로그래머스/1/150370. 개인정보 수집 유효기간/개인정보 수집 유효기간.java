import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private int pint(String s) {
        return Integer.parseInt(s);
    }
    
    private double parseToDouble(String day) {
        String[] splited = day.split("\\.");
        int yearToMonth = 12 * pint(splited[0]);
        int month = pint(splited[1]);
        double d = (double) pint(splited[2]) / 100;
    
        return d + yearToMonth + month;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        double todayD = parseToDouble(today);
        Map<Character, Integer> map = new HashMap<>();
        for (String term: terms) {
            String[] splited = term.split(" ");
            map.put(splited[0].charAt(0), pint(splited[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] splited = privacy.split(" ");
            double d = parseToDouble(splited[0]);
            char ch = splited[1].charAt(0);
            double gap = todayD - d;
            
            if (gap >= map.get(ch)) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}