package study_week2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> qu = new LinkedList<>();
        int sum = 0;
        int idx = 0;
        int time = 0;
        while(true){
            if(idx == truck_weights.length) break;
            if(qu.isEmpty()){ // 도로가 비어있을 때
                qu.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
                time++;
            }else if(qu.size() == bridge_length){ // 꽉 찼을 때
                // 빼고 추가할지 봐야하니까 이때는 시간 증가 X
                sum -= qu.poll();
            }else{ // 도로에 트럭 올릴 자리가 있을 때
                if(sum + truck_weights[idx] <= weight) {
                    qu.add(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                }else {
                    qu.add(0); // 이동칸 표시
                }
                time++;
            }
        }
        return time + bridge_length;
    }
}
