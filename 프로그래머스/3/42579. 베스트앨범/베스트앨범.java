import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, ArrayList<Album>> map2 = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int len = genres.length;
        
        for (int i = 0; i < len; i++) {
            if (map1.containsKey(genres[i])) {
                map1.put(genres[i], map1.get(genres[i]) + plays[i]);
                map2.get(genres[i]).add(new Album(plays[i], i));
            } else {
                map1.put(genres[i], plays[i]);
                map2.put(genres[i], new ArrayList<>());
                map2.get(genres[i]).add(new Album(plays[i], i));
            }
        }
        
        ArrayList<String> keySet = new ArrayList<>(map1.keySet());
        Collections.sort(keySet, (o1, o2) -> {
            return map1.get(o2) - map1.get(o1);
        });
        for (String key: map2.keySet()) {
            Collections.sort(map2.get(key));
        }
        
        for (String key: keySet) {
            for (int i = 0; i < Math.min(map2.get(key).size(), 2); i++) {
                answer.add(map2.get(key).get(i).number);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private class Album implements Comparable<Album> {
        int plays;
        int number;
        
        Album(int plays, int number) {
            this.plays = plays;
            this.number = number;
        }
        
        @Override
        public int compareTo(Album o) {
            return o.plays - this.plays;
        }
    }
}