package Lv1.day0225;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    public static void main(String[] args) {
        String[] s = {"ABACD", "BCEFD"};
        String[] t = {"ABCD", "AABB"};

        int ans[] = solution(s,t);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();
        for (String alp : keymap) {
            for (int i = 0; i < alp.length(); i++) {
                char c = alp.charAt(i);
                if(!map.containsKey(c) || map.get(c) > i+1){
                    map.put(c, i+1);
                }
            }
        }

        int idx = 0;
        for (String target : targets) {
            int count = 0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                if(map.containsKey(c)){
                    count += map.get(c);
                } else {
                    count = -1;
                    break;
                }
            }
            answer[idx] = count;
            idx++;
        }

        return answer;
    }
}
