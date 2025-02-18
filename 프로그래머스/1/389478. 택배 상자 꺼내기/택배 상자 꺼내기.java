class Solution {
    public int solution(int n, int w, int num) {
        int h = (num - 1) / w;
        int pos = h % 2 == 0 ? num - (h * w) : w + 1 - (num - (h * w));
        
        int right = (w - pos) * 2 + 1;
        int left = (pos - 1) * 2 + 1;
        int answer = 1;
        
        while (true) {
            if (h++ % 2 == 0) {
                num += right;
            } else {
                num += left;
            }
            
            if (num > n) break;
            answer++;
        }
        
        return answer;
    }
}