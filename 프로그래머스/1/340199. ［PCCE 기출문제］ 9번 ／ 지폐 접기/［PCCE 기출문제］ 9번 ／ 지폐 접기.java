class Solution {
    private void sort(int[] arr) {
        if (arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
    }
    
    private void fold(int[] arr) {
        arr[1] /= 2;
        sort(arr);
    }    
    
    public int solution(int[] wallet, int[] bill) {
        sort(wallet);
        sort(bill);
        
        int answer = 0;
        while (!(bill[0] <= wallet[0] && bill[1] <= wallet[1])) {
            answer++;
            fold(bill);
        }
        
        return answer;
    }
}