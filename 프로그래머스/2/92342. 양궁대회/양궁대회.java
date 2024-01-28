class Solution {
    private int gap = 0;
    private int[] answer = new int[11];
    private int[] arr = new int[11];
    
    private void dfs(int[] info, int depth, int val) {
        if (val < 0) {
            return;
        }
        
        if (depth == 11) {
            int apeach = 0;
            int lion = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] > 0 && info[i] >= arr[i]) {
                    apeach += 10 - i;
                } else if (arr[i] > 0) {
                    lion += 10 - i;
                }
            }
            
            int tempGap = lion - apeach;
            if (tempGap > 0) {
                if (tempGap > gap) {
                    gap = tempGap;
                    for (int i = 0; i < 11; i++) {
                        answer[i] = arr[i];
                    }
                } else if (tempGap == gap) {
                    for (int i = 10; i >= 0; i--) {
                        if (arr[i] > answer[i]) {
                            for (int j = 0; j < 11; j++) {
                                answer[j] = arr[j];
                            }
                            break;
                        } else if (arr[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
            
            return;
        }
        
        if (depth == 10) {
            arr[depth] = val;
            dfs(info, depth + 1, 0);
        } else {
            arr[depth] = info[depth] + 1;
            dfs(info, depth + 1, val - arr[depth]);
            arr[depth] = 0;
            dfs(info, depth + 1, val);
        }
    }
    
    public int[] solution(int n, int[] info) {
        dfs(info, 0, n);
        
        if (gap == 0) {
            return new int[] {-1};
        }
        return answer;
    }
}