// 3개의 영역으로 분리, deque 구조를 사용한다.
import java.util.ArrayDeque;


class Solution {
    private int N, M;
    private ArrayDeque<Integer> left = new ArrayDeque<>();
    private ArrayDeque<ArrayDeque<Integer>> center = new ArrayDeque<>();
    private ArrayDeque<Integer> right = new ArrayDeque<>();
    
    private void init(int[][] rc) {
        this.N = rc.length;
        this.M = rc[0].length;
        
        for (int i = 0; i < N; i++) {
            left.add(rc[i][0]);
            right.add(rc[i][M - 1]);
            
            ArrayDeque<Integer> c = new ArrayDeque<>();
            for (int j = 1; j < M - 1; j++) {
                c.add(rc[i][j]);
            }
            center.add(c);
        }
    }
    
    private void shiftRow() {
        left.addFirst(left.pollLast());
        center.addFirst(center.pollLast());
        right.addFirst(right.pollLast());
    }
    
    private void rotate() {
        ArrayDeque<Integer> centerPeek = center.peek();
        ArrayDeque<Integer> centerPeekLast = center.peekLast();
        centerPeek.addFirst(left.poll());
        right.addFirst(centerPeek.pollLast());
        centerPeekLast.add(right.pollLast());
        left.add(centerPeekLast.poll());
    }
    
    public int[][] solution(int[][] rc, String[] operations) {
        init(rc);
        for (String op: operations) {
            if (op.startsWith("S")) {
                shiftRow();
            } else {
                rotate();
            }
        }
        
        int[][] answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            answer[i][0] = left.poll();
            
            int index = 1;
            ArrayDeque<Integer> queue = center.poll();
            while (!queue.isEmpty()) {
                answer[i][index++] = queue.poll();
            }
            
            answer[i][M - 1] = right.poll();
        }
        
        return answer;
    }
}