class Solution {
    private static int answer = 0;
    private static char[][] charBoard;
    private static boolean run(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        boolean keepGoing = false;
        for (int i = 0; i < m - 1; i++) {
            point: for (int j = 0; j < n - 1; j++) {
                if (charBoard[i][j] == ' ') continue point;
                char ch = charBoard[i][j];
                for (int k = i; k < i + 2; k++) {
                    for (int l = j; l < j + 2; l++) {
                        if (charBoard[k][l] != ch) {
                            continue point;
                        }
                    }
                }
                for (int k = i; k < i + 2; k++) {
                    for (int l = j; l < j + 2; l++) {
                        visited[k][l] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    answer++;
                    keepGoing = true;
                    charBoard[i][j] = ' ';
                }
            }
        }
        
        if (keepGoing) {
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (charBoard[i][j] == ' ') {
                        for (int k = i - 1; k  >= 0; k--) {
                            if (charBoard[k][j] != ' ') {
                                charBoard[i][j] = charBoard[k][j];
                                charBoard[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return keepGoing;
    }
    public int solution(int m, int n, String[] board) {
        charBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            if (!run(m, n)) {
                 break;   
            }
        }
        
        return answer;
    }
}