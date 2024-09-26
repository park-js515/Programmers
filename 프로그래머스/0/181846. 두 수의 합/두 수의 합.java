class Solution {
    public String solution(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1, len2);
        
        int[] arr1 = new int[len + 1];
        int[] arr2 = new int[len + 1];
        for (int i = 0; i < len1; i++) {
            arr1[len - len1 + i + 1] = a.charAt(i) - '0';
        }
        for (int i = 0; i < len2; i++) {
            arr2[len - len2 + i + 1] = b.charAt(i) - '0';
        }
        
        int[] answer = new int[len + 1];
        for (int i = len; i >= 1; i--) {
            answer[i] += arr1[i] + arr2[i];
            if (answer[i] >= 10) {
                answer[i] -= 10;
                answer[i - 1]++;
            }
        }
        
        int start = answer[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < len + 1; i++) {
            sb.append(Integer.toString(answer[i]));
        }
        
        return sb.toString();
    }
}