class Solution {
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static int wordsListLength;
    private static int targetIdx = -1;
    private static boolean getAvailablity(String before, String after) {
        int len = before.length();
        int differ = 0;
        
        for (int i = 0; i < len; i++) {
            if (before.charAt(i) != after.charAt(i)) {
                differ++;
            }
        }
        
        return differ == 1;
    }
    private static void DFS(boolean[][] confusionMatrix, String[] wordsList, int beforeIndex, int depth) {
        if (depth != 0 && answer <= depth) return;
        if (depth == 0) {
            visited[0] = true;
            for (int i = 1; i < wordsListLength; i++) {
                if (confusionMatrix[0][i]) {
                    if (targetIdx == i) {
                        answer = 1;
                        return;
                    }
                    
                    visited[i] = true;
                    DFS(confusionMatrix, wordsList, i, 1);
                    visited[i] = false;
                }
            visited[0] = false;
            }
        } else {
            for (int i = 1; i < wordsListLength; i++) {
                if (!visited[i] && i == targetIdx && confusionMatrix[beforeIndex][i]) {
                    answer = depth + 1;
                    return;
                }
                if (!visited[i] && confusionMatrix[beforeIndex][i]) {
                    visited[i] = true;
                    DFS(confusionMatrix, wordsList, i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                targetIdx = i + 1;
                break;
            }
        }
        
        if (targetIdx == -1) {
            return 0;
        }
        
        wordsListLength = words.length + 1;
        String[] wordsList = new String[wordsListLength];
        boolean[][] confusionMatrix = new boolean[wordsListLength][wordsListLength];
        visited = new boolean[wordsListLength];
        wordsList[0] = begin;
        for (int i = 1; i < wordsListLength; i++) {
            wordsList[i] = words[i - 1];
        }
        for (int i = 0; i < wordsListLength; i++) {
            for (int j = 0; j < wordsListLength; j++) {
                confusionMatrix[i][j] = getAvailablity(wordsList[i], wordsList[j]);
            }
        }
        
        DFS(confusionMatrix, wordsList, 0, 0);
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}