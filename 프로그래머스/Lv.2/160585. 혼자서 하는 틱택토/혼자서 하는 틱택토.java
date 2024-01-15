// 위배되는 경우
// 1. 순서 자체를 위반
// 1 - 1. X가 O보다 갯수가 큰 경우
// 1 - 2. O가 X보다 2 개 이상 큰 경우
// 2. 성공 한 후 수를 둘 경우
// 2 - 1. O가 성공했는데, X의 갯수가 O랑 같은 경우
// 2 - 2. X가 성공했는데, O의 갯수가 X보다 큰 경우

class Solution {
    private boolean[] getResult(String[] board) {
        boolean[] ret = new boolean[2];
        for (int i = 0; i < 3; i++) {
            char ch1 = board[i].charAt(0);
            char ch2 = board[i].charAt(1);
            char ch3 = board[i].charAt(2);
            if (ch1 == 'O' && ch2 == 'O' && ch3 == 'O') {
                ret[0] = true;
            } else if (ch1 == 'X' && ch2 == 'X' && ch3 == 'X') {
                ret[1] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            char ch1 = board[0].charAt(i);
            char ch2 = board[1].charAt(i);
            char ch3 = board[2].charAt(i);
            if (ch1 == 'O' && ch2 == 'O' && ch3 == 'O') {
                ret[0] = true;
            } else if (ch1 == 'X' && ch2 == 'X' && ch3 == 'X') {
                ret[1] = true;
            }
        }
        char ch1 = board[0].charAt(0);
        char ch2 = board[1].charAt(1);
        char ch3 = board[2].charAt(2);
        char ch4 = board[0].charAt(2);
        char ch5 = board[2].charAt(0);
        if (ch1 == 'O' && ch2 == 'O' && ch3 == 'O') {
            ret[0] = true;
        } else if (ch1 == 'X' && ch2 == 'X' && ch3 == 'X') {
            ret[1] = true;
        }
        if (ch4 == 'O' && ch2 == 'O' && ch5 == 'O') {
            ret[0] = true;
        } else if (ch4 == 'X' && ch2 == 'X' && ch5 == 'X') {
            ret[1] = true;
        }
        
        return ret;
    };
    public int solution(String[] board) {
        int O = 0;
        int X = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    O++;
                } else if (board[i].charAt(j) == 'X') {
                    X++;
                }
            }
        }
        
        if (X > O) {
            return 0;
        }
        if (O - X > 1) {
            return 0;
        }
        
        boolean[] result = getResult(board);
        if (result[0] && result[1]) {
            return 0;
        }
        if (result[0] && (O != X + 1)) {
            return 0;
        } 
        if (result[1] && (O != X)) {
            return 0;
        }
        
        return 1;
    }
}