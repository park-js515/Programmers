import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private String patternString1 = "<meta property=\"og:url\" content=\"(\\S+)\"";
    private String patternString2 = "<a href=\"(\\S+)\"";
    
    public int solution(String word, String[] pages) {
        int len = pages.length;
        word = word.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> child = new HashMap<>();
        double[][] scores = new double[len][4];
        for (int i = 0; i < len; i++) {
            child.put(i, new ArrayList<>());
        }
        
        Pattern pattern1 = Pattern.compile(patternString1);
        Pattern pattern2 = Pattern.compile(patternString2);
        for (int i = 0; i < len; i++) {
            String page = pages[i].toLowerCase();
            pages[i] = page;
            Matcher match1 = pattern1.matcher(page);
            match1.find();
            map.put(match1.group(1), i);
            int cnt = 0;
            String[] parse = page.split("[^a-z]+");
            for (String p: parse) {
                if (p.equals(word)) {
                    cnt++;
                }
            }
            scores[i][0] = cnt;
        }

        for (int i = 0; i < len; i++) {
            String page = pages[i];
            Matcher match2 = pattern2.matcher(page);
            int cnt = 0;
            while (match2.find()) {
                cnt++;
                if (map.containsKey(match2.group(1))) {
                    child.get(i).add(map.get(match2.group(1)));
                }
            }
            scores[i][1] = cnt;
        }
        
        int answer = -1;
        double max = -1;
        for (int i = 0; i < len; i++) {
            double val = scores[i][0] / scores[i][1];
            for (int c: child.get(i)) {
                scores[c][2] += val;
            }
        }
        for (int i = 0; i < len; i++) {
            scores[i][3] = scores[i][0] + scores[i][2];
            if (scores[i][3] > max) {
                max = scores[i][3];
                answer = i;
            }
        }
        
        return answer;
    }
}