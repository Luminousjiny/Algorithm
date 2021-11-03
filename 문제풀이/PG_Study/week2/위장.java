package study_week2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])) map.put(clothes[i][1], map.get(clothes[i][1])+1);
            else map.put(clothes[i][1], 1);
        }
        if(map.size() == 1) return clothes.length;
        int num = 1;
        for(Map.Entry<String, Integer> m : map.entrySet()){
            num *= (m.getValue()+1); // 종류수 +1(안입는 경우)
        }
        return num-1; // 아예 안입는 경우 제외
    }
}
