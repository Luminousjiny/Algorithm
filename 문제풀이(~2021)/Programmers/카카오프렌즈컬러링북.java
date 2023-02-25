package PG_codingTestStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    public int[] di = {-1, 1, 0, 0};
    public int[] dj = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        int[][] copy = new int[m][n];
        for(int i=0; i<copy.length; i++){
            copy[i] = picture[i].clone();
        }

        ArrayList<Integer> areaSize = new ArrayList<>();
        Queue<Point> qu = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(copy[i][j] != 0){
                    int num = copy[i][j];
                    qu.add(new Point(i, j));
                    copy[i][j] = 0;
                    int cnt = 1;
                    while(!qu.isEmpty()){
                        Point now = qu.poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = now.x + di[dir];
                            int ny = now.y + dj[dir];
                            if(nx<0 || nx>=m || ny<0 || ny>=n || copy[nx][ny] != num || copy[nx][ny] == 0) continue;
                            qu.add(new Point(nx, ny));
                            copy[nx][ny] = 0;
                            cnt++;
                        }
                    }
                    areaSize.add(cnt);
                }
            }
        }
        Collections.sort(areaSize);
        int[] answer = new int[2];
        answer[0] = areaSize.size();
        answer[1] = areaSize.get(areaSize.size()-1);
        return answer;
    }

    public class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
