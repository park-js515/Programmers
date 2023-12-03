import java.util.HashMap;

class Solution {
    private static int getReverse(int direction) {
        switch(direction) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        
        return 0;
    }
    public int solution(String dirs) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][][] visited = new boolean[11][11][4];
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 2);
        map.put('L', 3);
        
        int r = 0, c = 0;
        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int direction = map.get(ch);
            int dr = r + d[direction][0];
            int dc = c + d[direction][1];
            
            if (dr >= -5 && dr <= 5 && dc >= -5 && dc <= 5) {                
                if (!visited[r + 5][c + 5][direction] && !visited[dr + 5][dc + 5][getReverse(direction)]) {
                    visited[r + 5][c + 5][direction] = true;
                    visited[dr + 5][dc + 5][getReverse(direction)] = true;
                    answer++;
                }
                r = dr;
                c = dc;

            }
        }
        return answer;
    }
}