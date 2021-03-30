package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
//        int[] priorities = {2,1,3,2};
        int lo = 0;
        int ans = solution(priorities, lo);
        System.out.println("---------------");
        System.out.println(ans);

    }
    static int solution(int[] priorities, int location) { // 중요도 배열, 내가 출력하고싶은 위치
        int answer = 0;
        Queue<Paper> pq = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(new Paper(i, priorities[i]));
        }

        while (!pq.isEmpty()){
            boolean chk = false;
            int num = pq.peek().priority;
            for (int j = 0; j < priorities.length; j++) {
                if(num < priorities[j]) {
                    chk = true;
                    break;
                }
            }
            if(chk) {
                pq.offer(pq.poll()); // 우선순위 큰게 존재 - 다시 넣어
            }
            else { // 아니면
                if(pq.poll().idx == location){ // 근데 내보낸게 내가 찾는 번호의 문서면 정답
                    answer = priorities.length - pq.size();
                    break;
                }
            }
        }
        return answer;
    }
    static class Paper { // 문서의 번호랑 우선순위
        int idx;
        int priority;

        Paper(int idx, int p) {
            this.idx = idx;
            this.priority = p;
        }
    }
}

