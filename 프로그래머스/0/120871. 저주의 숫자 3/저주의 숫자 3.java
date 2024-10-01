class Solution {
    public int solution(int n) {
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            while (index % 3 == 0 || Integer.toString(index).contains("3")) {
                index++;
            }
            index++;
        }
        
        
        return index - 1;
    }
}