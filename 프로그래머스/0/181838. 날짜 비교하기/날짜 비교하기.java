class Solution {
    private int dateToInt(int[] date) {
        return 365 * date[0] + 30 * date[1] + date[2];
    }
    
    public int solution(int[] date1, int[] date2) {
        return dateToInt(date1) < dateToInt(date2) ? 1 : 0;
    }
}