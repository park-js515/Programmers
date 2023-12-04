import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private static String enter(String name) {
        return name + "님이 들어왔습니다.";
    }
    private static String leave(String name) {
        return name + "님이 나갔습니다.";
    }
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<Record> list = new ArrayList<>();
        for (String r: record) {
            String[] splited = r.split(" ");
            boolean isEnter = splited[0].equals("Enter");
            boolean isLeave = splited[0].equals("Leave");
            boolean isChange = splited[0].equals("Change");
            String uid = splited[1];
            String nick = "";
            if (isEnter || isChange) {
                nick = splited[2];
            }
            
            if (isEnter || isLeave) {
                if (isEnter) {
                    map.put(uid, nick);
                }
                list.add(new Record(uid, isEnter));
            } else {
                map.put(uid, nick);
            }
            
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Record now = list.get(i);
            if (now.isEnter) {
                answer[i] = enter(map.get(now.uid));
            } else {
                answer[i] = leave(map.get(now.uid));
            }
        }
        return answer;
    }
    
    private static class Record {
        String uid;
        boolean isEnter;
        
        Record(String uid, boolean isEnter) {
            this.uid = uid;
            this.isEnter = isEnter;
        }
    }
}