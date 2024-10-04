class Solution {
    public int solution(int[] array) {
        int[] bucket = new int[1000];
        for (int i : array) bucket[i]++;
        
        int num = -1;
        int max = 0;
        for (int i = 0; i < 1000; i++) {
            if (max < bucket[i]) {
                num = i;
                max = bucket[i];
            } else if (max == bucket[i]) {
                num = -1;
                max = bucket[i];
            }
        }
        
        return num;
    }
}