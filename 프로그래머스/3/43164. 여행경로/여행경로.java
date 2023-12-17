import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    private boolean findAnswer = false;
    private String[] answer;
    private HashMap<String, ArrayList<City>> map = new HashMap<>();
    private void dfs(int len, int depth, String from) {
        if (depth == len + 1) {
            findAnswer = true;
            return;
        }
        if (!map.containsKey(from)) {
            return;
        }
        for (City city: map.get(from)) {
            if (findAnswer) return;
            if (!city.visited) {
                city.visited = true;
                answer[depth] = city.name;
                dfs(len, depth + 1, city.name);
                city.visited = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        
        for (String[] ticket: tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(new City(ticket[1]));
            } else {
                map.put(ticket[0], new ArrayList<>());
                map.get(ticket[0]).add(new City(ticket[1]));
            }
        }
        
        int len = tickets.length;
        answer = new String[len + 1];
        answer[0] = "ICN";
        dfs(len, 1, "ICN");
        
        return answer;
    }
    
    private class City {
    String name;
    boolean visited = false;

    City(String name) {
        this.name = name;
        }
    }
}