import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        ArrayList<String> ans = new ArrayList<>();
        // 1. record 돌면서 최종적 key, value 값 결정
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<record.length; i++){
            String[] now = record[i].split(" ");
            if(now[0].equals("Enter") || now[0].equals("Change")) map.put(now[1], now[2]);
        }

        // 2. record 돌면서 key로 value 값 + 첫단어에 따른 멘트를 answer
        for(int i=0; i<record.length; i++){
            String[] result = record[i].split(" ");
            String name = map.get(result[1]);
            if(result[0].equals("Enter")){
                ans.add(name+"님이 들어왔습니다.");
            }else if(result[0].equals("Leave")){
                ans.add(name+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
