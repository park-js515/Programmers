class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = food.length - 1; i >= 1; i--) {
            int cnt = food[i] / 2;
            for (int j = 0; j < cnt; j++) {
                sb.append(i);
                sb.insert(0, i);
            }
        }
        
        return sb.toString();
    }
}