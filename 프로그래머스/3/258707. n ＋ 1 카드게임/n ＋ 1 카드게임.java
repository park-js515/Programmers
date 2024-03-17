class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int answer = 0;
        int pair = 0;
        int chance1 = 0;
        int chance2 = 0;
        int[] visited = new int[n + 1];
        
        for (int i = 0; i < n / 3; i++) {
            visited[cards[i]] = 1;
            if (visited[n + 1 - cards[i]] == 1) {
                pair++;
            } 
        }
        
        for (int i = n / 3; i < n; i += 2) {
            int card1 = cards[i];
            int card2 = cards[i + 1];
            visited[card1] = 2;
            visited[card2] = 2;
            int target1 = n + 1 - card1;
            int target2 = n + 1 - card2;
            if (visited[target1] == 1) {
                chance1++;
            }
            if (visited[target2] == 1) {
                chance1++;
            }
            if (visited[target1] == 2) {
                chance2++;
            }
            if (visited[target1] == 2) {
                chance2++;
            }
            
            if (pair > 0) {
                pair--;
                answer++;
            } else {
                if (chance1 > 0 && coin > 0) {
                    coin--;
                    chance1--;
                    pair++;
                } else if (chance2 > 0 && coin > 1) {
                    coin -= 2;
                    chance2--;
                    pair++;
                }
                
                if (pair > 0) {
                    pair--;
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer + 1;
    }
}