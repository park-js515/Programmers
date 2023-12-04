import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        for (int i = 1; i < skill.length(); i++) {
            char ch = skill.charAt(i);
            map.put(ch, new ArrayList<>());
            for (int j = 0; j < i; j++) {
                char before = skill.charAt(j);
                map.get(ch).add(before);
            }
        }
        
        int answer = 0;
        point: for (int i = 0; i < skill_trees.length; i++) {
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (map.containsKey(skill_trees[i].charAt(j))) {
                    if (j == 0) continue point;
                    String st = skill_trees[i].substring(0, j);
                    for (char ch: map.get(skill_trees[i].charAt(j))) {
                        if (!st.contains(Character.toString(ch))) {
                            continue point;
                        }
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}