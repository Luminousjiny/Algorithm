package PG_codingTestStudy;

import java.util.ArrayList;

public class 기능개발_3 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            progresses[i] = (int) Math.ceil((double)(100-progresses[i])/speeds[i]);
        }
        int idx = 0;
        for(int j=idx; j<progresses.length-1; j++){
            if(progresses[idx] < progresses[j+1]){
                answer.add(j - idx +1);
                idx = j+1;
            }
        }
        answer.add(progresses.length - idx);

        int s = answer.size();
        int[] ans = new int[s];
        for(int i=0; i<s; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
