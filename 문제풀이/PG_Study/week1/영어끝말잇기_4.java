package PG_codingTestStudy;

import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기_4 {
    public int[] solution(int n, String[] words) {
        int id = 1;
        String before = words[0];
        Map<String, Integer> map = new HashMap<>();
        map.put(before, 1);
        for(int i=1; i<words.length; i++){
            if(id == n) id=0;
            String now = words[i];
            char last = before.charAt(before.length()-1);
            char first = now.charAt(0);
            if(now.length() == 1 || last != first || map.containsKey(now)){
                return new int[]{id + 1, i / n + 1};
            }
            map.put(now, 1);
            id++;
            before = now;
        }
        return new int[]{0, 0};
    }
}
