class Solution {
    public String[] solution(String[] str_list) {
        int len = str_list.length;
        String[] answer = {};
        
        for (int i = 0; i < len; i++) {
            if (str_list[i].equals("l")) {
                int size = i;
                answer = new String[size];
                for (int j = 0; j < size; j++) {
                    answer[j] = str_list[j];
                }
                break;
            }
            if (str_list[i].equals("r")) {
                int size = len - i - 1;
                int idx = i + 1;
                answer = new String[size];
                for (int j = 0; j < size; j++) {
                    answer[j] = str_list[idx++];
                }
                break;
            }
        }
        
        return answer;
    }
}