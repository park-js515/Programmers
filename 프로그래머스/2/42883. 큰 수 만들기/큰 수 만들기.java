class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int len = number.length();
        for (int i = 1; i <= k; i++) {
            boolean isRemoved = false;
            point: for (int j = 0; j < len - 1; j++) {
                if (sb.charAt(j) < sb.charAt(j + 1)) {
                    sb.replace(j, j + 1, "");
                    isRemoved = true;
                    break point;
                }
            }
            
            if (!isRemoved) {
                sb.replace(len - i, len - i + 1, "");
            }
        }
        
        return sb.toString();
    }
}