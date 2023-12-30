class Solution {
    private int[][] rotation(int M, int[][] key) {
        int[][] ret = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                ret[i][j] = key[M - 1 - j][i];
            }
        }
        
        return ret;
    }
    
    private int[][] resetLock(int N, int M, int[][] lock) {
        int len = N + 2 * (M - 1);
        int[][] ret = new int[len][len];
        
        for (int i = M - 1; i < M - 1 + N; i++) {
            for (int j = M - 1; j < M - 1 + N; j++) {
                ret[i][j] = lock[i - M + 1][j - M + 1];
            }
        }
        
        return ret;
    }
    
    private boolean test(int N, int M, int[][] key, int[][] lock) {
        for (int i = 0; i < M - 1 + N; i++) {
            point: for (int j = 0; j < M - 1 + N; j++) {
                int[][] nowLock = resetLock(N, M, lock);
                for (int k = i; k < i + M; k++) {
                    for (int l = j; l < j + M; l++) {
                        nowLock[k][l] += key[k - i][l - j];
                    }
                }
                
                for (int k = M - 1; k < M - 1 + N; k++) {
                    for (int l = M - 1; l < M - 1 + N; l++) {
                        if (nowLock[k][l] != 1) {
                            continue point;
                        }
                    }
                }
                
                return true;
            }
        }
        
        return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;
        
        for (int i = 0; i < 4; i++) {
            key = rotation(M, key);
            if (test(N, M, key, lock)) {
                return true;
            }
        }
        
        return false;
    }
}