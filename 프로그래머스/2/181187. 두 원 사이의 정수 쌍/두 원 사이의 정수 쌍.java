class Solution {
    public long solution(int r1, int r2) {        
        long R1 = (long) r1;
        long R2 = (long) r2;
        long base = R2 - R1 + 1;
        long cnt = 0;
        for (long i = 0; i <= R2; i++) {
            double dv1 = i <= R1 ? (double) Math.sqrt(R1 * R1 - i * i) : (double) 0;
            double dv2 = (double) Math.sqrt(R2 * R2 - i * i);
            long lv1 = (long) Math.ceil(dv1);
            long lv2 = (long) Math.floor(dv2);
            if (lv2 - lv1 >= 0) {
                cnt += lv2 - lv1 + 1;
            }
        }
        
        return (cnt - base) * 4;
    }
}