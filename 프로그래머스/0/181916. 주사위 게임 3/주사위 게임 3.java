class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] bucket = new int[7];
        bucket[a]++; bucket[b]++; bucket[c]++; bucket[d]++;
        
        // case1
        for (int i = 1; i <= 6; i++) {
            if (bucket[i] == 4) {
                return i * 1111;
            }
        }
        
        // case2
        for (int i = 1; i <= 6; i++) {
            if (bucket[i] == 3) {
                for (int j = 1; j <= 6; j++) {
                    if (bucket[j] == 1) {
                        return (10 * i + j) * (10 * i + j); 
                    }
                }
            }
        }
        
        // case3
        for (int i = 1; i <= 6; i++) {
            if (bucket[i] == 2) {
                for (int j = i + 1; j <= 6; j++) {
                    if (bucket[j] == 2) {
                        return (i + j) * Math.abs(i - j);
                    }
                }
            }
        }
        
        // case4
        for (int i = 1; i <= 6; i++) {
            if (bucket[i] == 2) {
                for (int j = 1; j <= 6; j++) {
                    if (bucket[j] == 1) {
                        for (int k = j + 1; k <= 6; k++) {
                            if (bucket[k] == 1) {
                                return j * k;
                            }
                        }
                    }
                }
            }
        }
        
        // case5
        int answer = 6;
        answer = Math.min(answer, a);
        answer = Math.min(answer, b);
        answer = Math.min(answer, c);
        answer = Math.min(answer, d);
        
        return answer;
    }
}