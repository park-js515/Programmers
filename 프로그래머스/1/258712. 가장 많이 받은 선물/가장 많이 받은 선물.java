import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private int[][] list;
    private int[] score;
    private int[] present;
    private int N;
    
    private void init(String[] friends) {
        N = friends.length;
        list = new int[N][N];
        score = new int[N];
        present = new int[N];
        for (int i = 0; i < N; i++) {
            map.put(friends[i], i);
        }
    }
    
    private void operation(String gift) {
        String[] splited = gift.split(" ");
        int from = map.get(splited[0]);
        int to = map.get(splited[1]);
        list[from][to]++;
        score[from]++;
        score[to]--;
    }
    
    public int solution(String[] friends, String[] gifts) {
        init(friends);
        for (String gift: gifts) {
            operation(gift);
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int score1 = score[i];
            for (int j = i + 1; j < N; j++) {
                int fromValue = list[i][j];
                int toValue = list[j][i];
                
                if (fromValue > toValue) {
                    present[i]++;
                } else if (fromValue < toValue) {
                    present[j]++;
                } else {
                    int score2 = score[j];
                    if (score1 > score2) {
                        present[i]++;
                    } else if (score1 < score2) {
                        present[j]++;
                    }
                }                
            }
        }

        for (int p: present) {
            answer = Math.max(answer, p);
        }
        
        return answer;
    }
}