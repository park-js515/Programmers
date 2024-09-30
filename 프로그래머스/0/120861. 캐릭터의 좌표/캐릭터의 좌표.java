import java.util.*;

class Solution {
    private Map<String, int[]> map = Map.of(
        "up", new int[] {0, 1},
        "down", new int[] {0, -1},
        "left", new int[] {-1, 0},
        "right", new int[] {1, 0}
    );
    
    public int[] solution(String[] keyinput, int[] board) {
        int row = board[0] / 2;
        int col = board[1] / 2;
        int[] pos = new int[2];
        
        for (String s : keyinput) {
            int[] d = map.get(s);
            int dr = pos[0] + d[0];
            int dc = pos[1] + d[1];
            
            if (dr < -row || dr > row || dc < -col || dc > col) continue;
            pos = new int[] {dr, dc};
        }
        
        return pos;
    }
}