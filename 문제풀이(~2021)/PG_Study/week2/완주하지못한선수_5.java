package study_week2;

import java.util.HashMap;

// 시간 복잡도 O(n)
public class 완주하지못한선수_5 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> person = new HashMap<>();
        //  O(n)
        for (int i = 0; i < participant.length; i++) {
            person.put(participant[i], person.getOrDefault(participant[i], 0)+1);
        }

        //  O(n)
        for (int i = 0; i < completion.length; i++) {
            if(person.containsKey(completion[i])){
                person.put(completion[i], person.get(completion[i])-1);
            }
        }
//        for(Map.Entry<String, Integer> e : person.entrySet()){
//            if(e.getValue() > 0) {
//                answer = e.getKey();
//                break;
//            }
//        }
        return person.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .findFirst()
                .get()
                .getKey();
    }
}
