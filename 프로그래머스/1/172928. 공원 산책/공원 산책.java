import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<Character, int[]> map = new HashMap<>() {{
        put('N', new int[] {-1, 0});
        put('S', new int[] {1, 0});
        put('W', new int[] {0, -1});
        put('E', new int[] {0, 1});
    }};
    
    private boolean[][] field;
    private int N, M;
    private int[] pos;
    
    private void init(String[] park) {
        N = park.length;
        M = park[0].length();
        field = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char ch = park[i].charAt(j);
                if (ch == 'X') {
                    field[i][j] = true;
                } else if (ch == 'S') {
                    pos = new int[] {i, j};
                }
            }
        }
    }
    
    private void move(String route) {
        String[] splited = route.split(" ");
        int[] d = map.get(splited[0].charAt(0));
        int size = Integer.parseInt(splited[1]);
        
        int dr = pos[0] + d[0] * size;
        int dc = pos[1] + d[1] * size;
        if (dr < 0 || dr >= N || dc < 0 || dc >= M) return;
        
        int rs = Math.min(pos[0], dr);
        int re = Math.max(pos[0], dr);
        int cs = Math.min(pos[1], dc);
        int ce = Math.max(pos[1], dc);
        for (int i = rs; i <= re; i++) {
            for(int j = cs; j <= ce; j++) {
                if (field[i][j]) return;
            }
        }
        
        pos = new int[] {dr, dc};
    }
    
    public int[] solution(String[] park, String[] routes) {
        init(park);
        for (String route: routes) {
            move(route);
        }
        
        return pos;
    }
}