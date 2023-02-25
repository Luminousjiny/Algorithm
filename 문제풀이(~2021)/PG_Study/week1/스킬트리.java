package PG_codingTestStudy;

import java.util.HashMap;
import java.util.Map;
// indexOf를 사용
// skill의 인덱스 순서와 skill_trees[] 의 문자 인덱스 순서와 같은지 비교해서 체크
public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            map.put(skill.charAt(i), 1);
        }
        for(int i=0; i<skill_trees.length; i++){
            int cnt = 0;
            boolean check = true;
            for(int j=0; j<skill_trees[i].length(); j++){
                if(map.containsKey(skill_trees[i].charAt(j))){
                    if(cnt != skill.indexOf(skill_trees[i].charAt(j))){
                        check = false;
                        break;
                    }
                    cnt++;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}
