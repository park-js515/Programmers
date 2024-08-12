import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        ArrayDeque<Integer>[] stack = new ArrayDeque[N];
        for (int i = 0; i < N; i++) {
            stack[i] = new ArrayDeque<>();
        }
        
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][j] == 0) continue;
                stack[j].add(board[i][j]);
            }
        }
        
        int answer = 0;
        ArrayDeque<Integer> bascket = new ArrayDeque<>();
        for (int move: moves) {
            move--;
            if (stack[move].isEmpty()) continue;
            int p = stack[move].pollLast();
            if (bascket.size() > 0 && bascket.peekLast() == p) {
                bascket.pollLast();
                answer += 2;
            } else {
                bascket.add(p);
            }
        }
        
        return answer;
    }
}