import java.util.ArrayList;

class Solution {
    private ArrayList<int[]> list = new ArrayList<>();
    private void hanoi(int n, int from, int to, int mid) {
        if (n == 1) {
            list.add(new int[] {from, to});
            return;
        }
        hanoi(n - 1, from, mid, to);
        list.add(new int[] {from, to});
        hanoi(n - 1, mid, to, from);
    }
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}