import java.util.Arrays;

class Solution {
    private String answer = "No";
    private String[] cards1;
    private String[] cards2;
    private String[] goal;
    private int n1, n2, N;
    private String[] arr;
    
    private void init(String[] cards1, String[] cards2, String[] goal) {
        this.cards1 = cards1;
        this.cards2 = cards2;
        this.goal = goal;
        this.n1 = cards1.length;
        this.n2 = cards2.length;
        this.N = goal.length;
        this.arr = new String[this.N];
    }
    
    private void dfs(int depth, int a, int b) {
        if (answer.equals("Yes")) return;
        if (depth == N) {
            if (Arrays.equals(arr, goal)) {
                answer = "Yes";
            }
            return;
        }
        
        if (a < this.n1) {
            arr[depth] = this.cards1[a];
            dfs(depth + 1, a + 1, b);
        }
        if (b < this.n2) {
            arr[depth] = this.cards2[b];
            dfs(depth + 1, a, b + 1);
        }
    }
    
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        init(cards1, cards2, goal);
        dfs(0, 0, 0);
        
        return answer;
    }
}