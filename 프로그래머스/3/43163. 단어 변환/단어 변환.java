import java.util.*;

class Solution {
    private boolean check(int n, String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == 1;
    }
    
    private int bfs(int begin, int target, boolean[][] convertMatrix) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        int MAX = 50;
        queue.add(begin);
        cntMap.put(begin, 0);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int i = 0; i < convertMatrix.length; i++) {
                if (convertMatrix[now][i] && cntMap.getOrDefault(i, MAX) > cntMap.get(now) + 1) {
                    cntMap.put(i, cntMap.get(now) + 1);
                    queue.add(i);
                }
            }
        }
        
        return cntMap.getOrDefault(target, 0);
    }
    
    public int solution(String begin, String target, String[] words) {
        int n = words.length + 1;
        boolean[][] convertMatrix = new boolean[n][n];
        List<String> list = new ArrayList<>();
        
        list.add(begin);
        for (int i = 0; i < n - 1; i++) {
            list.add(words[i]);
        }
        
        if (!list.contains(target)) {
            return 0;
        }
        
        int wordLength = begin.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                convertMatrix[i][j] = check(wordLength, list.get(i), list.get(j));
                convertMatrix[j][i] = convertMatrix[i][j];
            }
        }
        
        return bfs(0, list.indexOf(target), convertMatrix);
    }
}