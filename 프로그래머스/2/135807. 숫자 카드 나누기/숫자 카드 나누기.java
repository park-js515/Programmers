class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        boolean aIsTrue = true;
        boolean bIsTrue = true;
        
        for (int a: arrayA) {
            gcdA = gcd(gcdA, a);
        }
        for (int b: arrayB) {
            gcdB = gcd(gcdB, b);
        }
        
        for (int b: arrayB) {
            if (b % gcdA == 0) {
                aIsTrue = false;
                break;
            }
        }
        
        for (int a: arrayA) {
            if (a % gcdB == 0) {
                bIsTrue = false;
                break;
            }
        }
        
        if (aIsTrue && bIsTrue) {
            return Math.max(gcdA, gcdB);
        } else if (aIsTrue) {
            return gcdA;
        } else if (bIsTrue) {
            return gcdB;
        } else {
            return 0;
        }
    }
}