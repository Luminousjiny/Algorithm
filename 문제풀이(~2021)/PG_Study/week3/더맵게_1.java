package study_week3;

import java.util.PriorityQueue;

public class 더맵게_1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.peek() < K){
            if(pq.size() < 2) return -1;
            int first = pq.poll();
            int second = pq.poll();
            int cal = first + (second*2);
            pq.add(cal);
            answer++;
        }
        return answer;
    }
}
