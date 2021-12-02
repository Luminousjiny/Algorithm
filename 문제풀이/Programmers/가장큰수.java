package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        // numbers를 String으로 보고 맨 앞문자 기준으로 내림차순 정렬
        ArrayList<String> numTostring = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            numTostring.add(Integer.toString(numbers[i]));
        }
        // 방법1. 람다식 사용
        // Collections.sort(numTostring, (s1, s2)->(s1+s2).compareTo(s2+s1)); -> 내림차순
         Collections.sort(numTostring, (s1, s2)->(s2+s1).compareTo(s1+s2)); // -> 오름차순

        // 방법2. comparator에서 compare @Override 해서 사용
//        Collections.sort(numTostring, new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                return((s2+s1).compareTo(s1+s2));
//            }
//        });

        if(numTostring.get(0).equals("0")) return "0";
        for(int i=0; i<numTostring.size(); i++){
            answer += numTostring.get(i);
        }

        return answer;
    }
}
