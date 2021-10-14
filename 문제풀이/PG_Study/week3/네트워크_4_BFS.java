package study_week3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크_4_BFS {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n]; // 정점 수
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            Queue<Integer> qu = new LinkedList<>();
            qu.add(i);
            visit[i] = true;
            while (!qu.isEmpty()){
                int now = qu.poll();
                for (int j = 0; j < n; j++) {
                    if(!visit[j] && computers[now][j] == 1){
                        qu.add(j);
                        visit[j] = true;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
