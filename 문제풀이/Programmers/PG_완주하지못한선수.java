package day0725;

import java.util.HashMap;
import java.util.Map;

public class PG_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> person = new HashMap<>(); // 이름, 인원수
        for (int i = 0; i < completion.length; i++) {
            if(person.containsKey(completion[i])){
                int num = person.get(completion[i]);
                person.replace(completion[i], num+1);
            }else{
                person.put(completion[i], 1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if(person.containsKey(participant[i])){
                int num = person.get(participant[i]);
                if(num == 0){
                    answer = participant[i];
                    break;
                }
                person.replace(participant[i], num-1);
            }else{
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
