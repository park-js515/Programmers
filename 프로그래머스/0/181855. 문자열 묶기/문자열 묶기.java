class Solution {
    public int solution(String[] strArr) {
        int[] bucket = new int[31];
        for (String s : strArr) {
            bucket[s.length()]++;
        }
        

        int max = 0;
        for (int i = 0; i < 31; i++) {
            max = Math.max(max, bucket[i]);
        }
        
        return max;
    }
}