import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Music>> count = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            total.put(genre, total.getOrDefault(genre, 0) + play);
            count.computeIfAbsent(genre, key -> new ArrayList<Music>()).add(new Music(i, play));
        }
        
        List<String> genreOrder = new ArrayList<>(total.keySet());
        Collections.sort(genreOrder, (o1, o2) -> Integer.compare(total.get(o2), total.get(o1)));
        
        List<Integer> answer = new ArrayList<>();
        for (String k : genreOrder) {
            List<Music> m = count.get(k);
            Collections.sort(m);
            
            for (int i = 0; i < Math.min(m.size(), 2); i++) {
                answer.add(m.get(i).idx);
            }
        }
            
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private class Music implements Comparable<Music> {
        int idx, play;
        
        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            if (o.play != this.play) {
                return Integer.compare(o.play,this.play);
            }
            return Integer.compare(this.idx, o.idx);
        }
    }
    
}