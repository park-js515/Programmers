import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

// 해당 단어에 누적된 스포방지
// 인덱스 -> 단어 Map
// 단어가 이미 등장했는지 확인하기 위한 Set
// 현재 위치가 어떤 단어 속하는지 알기 위한 표시

class Solution {
    private int n;
    private int[] index;
    private Map<Integer, String> indexToWord;
    private Map<Integer, Integer> spoilCnt;
    private Set<String> wordSet;
    private int answer = 0;
    
    private void init(String message) {
        n = message.length();
        index = new int[n];
        indexToWord = new HashMap<>();
        spoilCnt = new HashMap<>();
        wordSet = new HashSet<>();
        
        int nowIndex = 0;
        int wordIndex = 1;
        StringBuilder sb = new StringBuilder();
        while (nowIndex < n) {
            if (message.charAt(nowIndex) != ' ') {
                sb.append(message.charAt(nowIndex));
                index[nowIndex] = wordIndex;
            } else {
                if (sb.length() != 0) {
                    String st = sb.toString();
                    indexToWord.put(wordIndex, st);
                    spoilCnt.put(wordIndex, 0);
                    wordIndex++;
                }
                sb = new StringBuilder();
            }
            nowIndex++;
        }
        
        if (sb.length() != 0) {
            String st = sb.toString();
            indexToWord.put(wordIndex, st);
            spoilCnt.put(wordIndex, 0);
        }
    }
    
    private void spoil(int[][] spoiler_ranges) {
        int wordCnt = indexToWord.size();
        
        for (int[] spoiler_range: spoiler_ranges) {
            int start = spoiler_range[0];
            int end = spoiler_range[1] + 1;
            boolean[] visited = new boolean[wordCnt + 1];

            for (int i = start; i < end; i++) {
                int targetIndex = index[i];
                if (targetIndex != 0 && !visited[targetIndex]) {
                    visited[targetIndex] = true;
                    spoilCnt.put(targetIndex, spoilCnt.get(targetIndex) + 1);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry: spoilCnt.entrySet()) {
            if (entry.getValue() == 0) {
                wordSet.add(indexToWord.get(entry.getKey()));
            }
        }
    }
    
    private void removeSpoil(int[][] spoiler_ranges) {
        int wordCnt = indexToWord.size();
        
        for (int[] spoiler_range: spoiler_ranges) {
            int start = spoiler_range[0];
            int end = spoiler_range[1] + 1;
            
            boolean[] visited = new boolean[wordCnt + 1];
            for (int i = start; i < end; i++) {
                int targetIndex = index[i];
                if (targetIndex != 0 && !visited[targetIndex]) {
                    visited[targetIndex] = true;
                    spoilCnt.put(targetIndex, spoilCnt.get(targetIndex) - 1);
                    if (spoilCnt.get(targetIndex) == 0 && 
                        !wordSet.contains(indexToWord.get(targetIndex))) {
                        answer++;
                        wordSet.add(indexToWord.get(targetIndex));
                    }
                }
            }
        }
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        init(message);
        spoil(spoiler_ranges);
        removeSpoil(spoiler_ranges);

        return answer;
    }
}