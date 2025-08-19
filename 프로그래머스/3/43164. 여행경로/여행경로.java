import java.util.*;

class Solution {
    private int n;
    private Map<String, List<Flight>> map = new HashMap<>();
    private boolean findAnswer = false;
    
    private void init(String[][] tickets) {
        this.n = tickets.length + 1;
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            map.computeIfAbsent(from, key -> new ArrayList<>()).add(new Flight(to));
        }
    }
    
    private void dfs(int depth, String arr[]) {
        if (findAnswer) return;
        if (depth == n) {
            findAnswer = true;
            return;
        }
        
        if (!map.containsKey(arr[depth - 1])) {
            return;
        }
        for (Flight f : map.get(arr[depth - 1])) {
            if (findAnswer) return;
            if (!f.visited) {
                f.visited = true;
                arr[depth] = f.to;
                dfs(depth + 1, arr);
                f.visited = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        init(tickets);
        String[] answer = new String[n];
        answer[0] = "ICN";
        
        dfs(1, answer);
        return answer;
    }
    
    private class Flight {
        String to;
        boolean visited;
        
        public Flight(String to) {
            this.to = to;
            this.visited = false;
        }
        
        @Override
        public String toString() {
            return to;
        }
    }
}