import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayDeque<Item> stack = new ArrayDeque<>();
        int len = numbers.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    Item item = stack.peekLast();
                    if (item.number < numbers[i]) {
                        stack.pollLast();
                        answer[item.index] = numbers[i];
                    } else {
                        break;
                    }
                }
            } 
            stack.add(new Item(numbers[i], i));
        }
        return answer;
    }
    
    private static class Item {
        int number, index;
        
        Item(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
}