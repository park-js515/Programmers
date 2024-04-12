import java.util.HashMap;
import java.util.Map;

class Solution {
    private TrieNode rootNode1 = new TrieNode();
    private TrieNode rootNode2 = new TrieNode();
    
    private void insert(TrieNode node, String word) {        
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> cnt = node.getCnt();
            cnt.put(len, cnt.getOrDefault(len, 0) + 1);
            node = node.getChildNodes()
                .computeIfAbsent(word.charAt(i), key -> new TrieNode());
        }
        Map<Integer, Integer> cnt = node.getCnt();
        cnt.put(len, cnt.getOrDefault(len, 0) + 1);
        
        node.setIsLastChar(true);
    }
    
    private int findPattern(TrieNode node, String word) {
        int cnt = 0;
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            
            if (ch != '?') {
                node = node.getChildNodes().get(ch);
                if (node == null) {
                    break;
                }
            } else {
                cnt = node.getCnt().getOrDefault(len, 0);
                break;
            }
        }
        
        return cnt;
    }
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        for (String word: words) {
            String rev = (new StringBuilder(word)).reverse().toString();
            insert(rootNode1, word);
            insert(rootNode2, rev);
        }
        
        for (int i = 0; i < queries.length; i++) {
            if (queries[i].charAt(0) != '?') {
                String query = queries[i];
                answer[i] = findPattern(rootNode1, query);
            } else {
                String query = (new StringBuilder(queries[i])).reverse().toString();
                answer[i] = findPattern(rootNode2, query);
            }
        }
        
        return answer;
    }
    
    private class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;
        private Map<Integer, Integer> cnt = new HashMap<>(); 
        
        public Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        
        public boolean isLastChar() {
            return this.isLastChar;
        }
        
        public void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
        
        public Map<Integer, Integer> getCnt() {
            return this.cnt;
        }
    }
}