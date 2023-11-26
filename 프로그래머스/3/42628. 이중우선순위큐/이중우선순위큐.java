import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    private static int index = 0;
    private static boolean[] deleteList = new boolean[1000000];
    private static PriorityQueue<int[]> maxQ = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
    private static PriorityQueue<int[]> minQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    private static void insert(int num) {
        maxQ.add(new int[] {num, index});
        minQ.add(new int[] {num, index++});
    }
    private static void delete(int operator) {
        if (operator == -1) {
            while (!minQ.isEmpty() && deleteList[minQ.peek()[1]]) {
                minQ.poll();
            }
            if (minQ.isEmpty()) return;
            deleteList[minQ.poll()[1]] = true;
        }
        else {
            while (!maxQ.isEmpty() && deleteList[maxQ.peek()[1]]) {
                maxQ.poll();
            }
            if (maxQ.isEmpty()) return;
            deleteList[maxQ.poll()[1]] = true;
        }
    }
    
    
    public int[] solution(String[] operations) {
        for (int op = 0; op < operations.length; op++) {
            String[] operation = operations[op].split(" ");
            char oper = operation[0].charAt(0);
            int num = Integer.parseInt(operation[1]);
            
            if (oper == 'I') {
                insert(num);
            } 
            else {
                delete(num);
            }
        }
        
        while (!minQ.isEmpty() && deleteList[minQ.peek()[1]]) {
            minQ.poll();
        }
        while (!maxQ.isEmpty() && deleteList[maxQ.peek()[1]]) {
            maxQ.poll();
        }
        
        int[] answer = {0, 0};
        if (!minQ.isEmpty()) {
            answer[1] = minQ.peek()[0];
        }
        if (!maxQ.isEmpty()) {
            answer[0] = maxQ.peek()[0];
        }
        
        return answer;
    }
}