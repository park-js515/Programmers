class Solution {
    private int[][] cross1 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] cross2 = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private int[][] cross2Adj = {{0, 2}, {0, 3}, {1, 2}, {1, 3}}; 
    private boolean bfs(String[] place, int r, int c) {
        boolean[] blocked = new boolean[4];
        
        // 상하좌우 맨하탄 거리 1
        for (int i = 0; i < 4; i++) {
            int dr = r + cross1[i][0];
            int dc = c + cross1[i][1];
            if (dr < 0 || dr >= 5 || dc < 0 || dc >= 5) continue;
            if (place[dr].charAt(dc) == 'P') {
                return false;
            } else if (place[dr].charAt(dc) == 'X') {
                blocked[i] = true;
            }
        }
        
        // 대각선 맨하탄 거리 2
        for (int i = 0; i < 4; i++) {
            int dr = r + cross2[i][0];
            int dc = c + cross2[i][1];
            if (dr < 0 || dr >= 5 || dc < 0 || dc >= 5) continue;
            if (place[dr].charAt(dc) == 'P') {
                for (int j: cross2Adj[i]) {
                    int ar = r + cross1[j][0];
                    int ac = c + cross1[j][1];
                    if (ar < 0 || ar >= 5 || ac < 0 || ac >= 5) continue;
                    if (!blocked[j]) {
                        return false;
                    }
                }
            }
        }
        
        // 상하좌우 맨하탄 거리2
        for (int i = 0; i < 4; i++) {
            if (blocked[i]) continue;
            int dr = r + cross1[i][0] * 2;
            int dc = c + cross1[i][1] * 2;
            if (dr < 0 || dr >= 5 || dc < 0 || dc >= 5) continue;
            if (place[dr].charAt(dc) == 'P') {
                return false;
            }
        }
        
        return true;
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        point: for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (place[j].charAt(k) == 'P') {
                        if (!bfs(place, j, k)) {
                            continue point;
                        } 
                    }
                }
            }
            
            answer[i] = 1;
        }
        
        return answer;   
    }
}