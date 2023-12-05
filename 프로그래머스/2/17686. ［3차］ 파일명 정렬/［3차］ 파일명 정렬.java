import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        int len = files.length;
        FileItem[] fileItems = new FileItem[len];
        for (int i = 0; i < len; i++) {
            fileItems[i] = new FileItem(files[i]);
        }
        Arrays.sort(fileItems);
        
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = fileItems[i].origin;
        }
        return answer;
    }
    
    private class FileItem implements Comparable<FileItem> {
        String origin, head;
        int number;
        
        FileItem(String origin) {
            this.origin = origin;
            int len = origin.length();
            
            int idx1 = 0;
            for (int i = 0; i < len; i++) {
                char ch = origin.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    idx1 = i;
                    break;
                }
            }
            head = origin.substring(0, idx1).toLowerCase();
            
            int idx2 = idx1;
            boolean isBreaked = false;
            for (int i = idx2; i < len; i++) {
                char ch = origin.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    continue;
                } else {
                    isBreaked = true;
                    idx2 = i;
                    break;
                }
            }    
            if (!isBreaked) {
                idx2 = len;
            }
            number = Integer.parseInt(origin.substring(idx1, idx2));
        }
        
        @Override
        public int compareTo(FileItem o) {
            int diff = this.head.compareTo(o.head);
            if (diff == 0) {
                return this.number - o.number;
            } else {
                return diff;
            }
        }
    }
}