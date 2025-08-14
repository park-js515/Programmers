import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        ArrayDeque<Stock> stack = new ArrayDeque<>();
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            Stock stock = new Stock(prices[i], i);
            
            while (!stack.isEmpty() && stack.peekLast().p > stock.p) {
                Stock out = stack.pollLast();
                answer[out.idx] = i - out.idx;
            }
            
            stack.add(stock);
        }
        
        if (!stack.isEmpty()) {
            int lastIdx = stack.pollLast().idx;
            
            while (!stack.isEmpty()) {
                Stock temp = stack.pollLast();
                answer[temp.idx] = lastIdx - temp.idx;
            }
        }
        
        return answer;
    }
    
    private class Stock {
        int p, idx;
        
        public Stock(int p, int idx) {
            this.p = p;
            this.idx = idx;
        }
    }
}