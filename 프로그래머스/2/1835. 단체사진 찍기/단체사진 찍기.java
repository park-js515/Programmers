import java.util.HashMap;

class Solution {
    private int answer = 0;
    private final String FRIENDS = "ACFJMNRT";
    private char[] arr = new char[8];
    private boolean[] visited = new boolean[8];
    private HashMap<Character, Integer> map = new HashMap<>();
    
    private int[] getDistance() {
        int[] dist = new int[8];
        String st = new String(arr);
        for (int i = 0; i < 8; i++) {
            int index = st.indexOf(FRIENDS.charAt(i));
            dist[i] = index;
        }
        
        return dist;
    }
    
    private void dfs(Data[] Datas, int depth) {
        if (depth == 8) {
            int[] dist = getDistance();
            for (Data d: Datas) {
                int from = dist[d.from];
                int to = dist[d.to];
                int gap = Math.abs(from - to);
                if (d.op == '=') {
                    if (gap != d.dist) {
                        return;
                    }
                } else if (d.op == '<') {
                    if (gap >= d.dist) {
                        return;
                    }
                } else {
                    if (gap <= d.dist) {
                        return;
                    }
                }
            }
            answer++;
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = FRIENDS.charAt(i);
                dfs(Datas, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    
    public int solution(int n, String[] data) {
        for (int i = 0; i < 8; i++) {
            map.put(FRIENDS.charAt(i), i);
        }
        Data[] Datas = new Data[n];
        for (int i = 0; i < n; i++) {
            Datas[i] = new Data(data[i]);
        }
        
        dfs(Datas, 0);
        
        return answer;
    }
    
    private class Data {
        int from, to;
        char op;
        int dist;
        
        public Data(String s) {
            this.op = s.charAt(3);
            String[] temp = s.split(Character.toString(op));
            this.from = map.get(temp[0].charAt(0));
            this.to = map.get(temp[0].charAt(2));
            this.dist = Integer.parseInt(temp[1]) + 1;
        }
    }
}