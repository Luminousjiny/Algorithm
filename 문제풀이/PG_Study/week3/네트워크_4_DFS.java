package study_week3;

public class 네트워크_4_DFS {
    static boolean[] visit;
    static int[][] map;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        map = computers;
        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            dfs(i);
            answer++;
        }
        return answer;
    }

    private void dfs(int i) {
        visit[i] = true;
        for (int j = 0; j < map.length; j++) {
            if(!visit[j] && map[i][j] == 1){
                dfs(j);
            }
        }
    }
}
