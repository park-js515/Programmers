import java.util.*;

class Solution {
    private void getPairs(int sum, List<Pair> list) {
        for (int i = 3; i <= (int) Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                list.add(new Pair(sum / i, i));
            }
        }
    }
    
    private int[] getAnswer(int yellow, List<Pair> list) {
        Pair pair = new Pair(0, 0);
        
        for (Pair p : list) {
            if ((p.x - 2) * (p.y - 2) == yellow) {
                pair = p;
                break;
            }
        }
        
        int[] answer = {pair.x, pair.y};
        return answer;
    }
        
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        List<Pair> list = new ArrayList<>();
        getPairs(sum, list);

        return getAnswer(yellow, list);
    }
    
    private class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
}