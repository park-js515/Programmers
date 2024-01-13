// 위쪽에서부터 아래로 내려오면서 왼쪽 오른쪽으로 나누면서 풀면된다.
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;

class Solution {
    private int index1 = 0;
    private int index2 = 0;
    private int[][] answer;
    
    private void init(Node node, ArrayDeque<Node> list) {
        if (list.isEmpty()) {
            return;
        }
        
        ArrayDeque<Node> left = new ArrayDeque<>();
        ArrayDeque<Node> right = new ArrayDeque<>();
        for (Node now: list) {
            if (now.x < node.x) {
                left.add(now);
            } else {
                right.add(now);
            }
        }
        
        if (left.size() > 0) {
            node.left = left.poll();
            init(node.left, left);
        }
        if (right.size() > 0) {
            node.right = right.poll();
            init(node.right, right);
        }
    }
    
    private void order(Node start) {
        if (start == null) {
            return;
        }
        
        answer[0][index1++] = start.index;
        order(start.left);
        order(start.right);
        answer[1][index2++] = start.index;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(list);
        ArrayDeque<Node> queue = new ArrayDeque<>(list);
        Node start = queue.poll();
        
        init(start, queue);
        answer = new int[2][len];
        order(start);
        
        return answer;
    }
    
    private class Node implements Comparable<Node> {
        int index, x, y;
        Node left, right;
        
        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this. y = y;
        };
        
        @Override
        public int compareTo(Node o) {
            if (this.y != o.y) {
                return o.y - this.y;
            }
            return this.x - o.x;
        }
    }
}