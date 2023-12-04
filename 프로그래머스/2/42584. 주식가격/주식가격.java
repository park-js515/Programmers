import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Stock> stack = new ArrayDeque<>();
        int len = prices.length;
        int[] answer = new int[len];
        int time = 0;
        
        while (time < len) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    Stock stock = stack.peekLast();
                    if (stock.price > prices[time]) {
                        stack.pollLast();
                        answer[stock.time] = time - stock.time;
                    } else {
                        break;
                    }
                }
            }
            stack.add(new Stock(prices[time], time));
            time++;
        }
        time--;
        while (!stack.isEmpty()) {
            Stock stock = stack.pollLast();
            answer[stock.time] = time - stock.time;
        }
        return answer;
    }
    
    private static class Stock {
        int price, time;
        
        Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }
}