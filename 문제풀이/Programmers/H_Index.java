package test;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // h값보다 큰 개수가 h개 이상이어야 함
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i; // 기준이자 개수
            if(citations[i] >= h){ // 값이 개수(기준) 보다 커지거나 같으면 그 순간 정답
                answer = h;
                break;
            }
        }
        return answer;
    }
}
