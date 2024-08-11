class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int temp = arr1[i] | arr2[i];
            String temp2 = Integer.toBinaryString(temp);
            temp2 = temp2.replace("1", "#");
            temp2 = temp2.replace("0", " ");
            while (temp2.length() < n) {
                temp2 = " " + temp2;
            }
            answer[i] = temp2;
        }
        
        return answer;
    }
}