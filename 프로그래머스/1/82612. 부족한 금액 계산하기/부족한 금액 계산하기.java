class Solution {
    private int getSum(int n) {
        return (n * (n + 1)) / 2;
    }
    
    public long solution(int price, int money, int count) {
        long total = (long) getSum(count) * price;
        
        if (total - money >= 0) return total - money;
        return 0;
    }
}