package day1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea8382 {
    static StringTokenizer st;
    static int[] di = {0,-1,0,1,0}; // 시계방향
    static int[] dj = {0,0,1,0,-1};
    static boolean[][][] visit;
    static int dist, ans; // 최소거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;

            ans = 0; // 같은 자리로 이동할때가 있을 수 있으므로 초기화
            visit = new boolean[2][201][201]; // mod = 0 -> 가로이동, mod = 1 -> 세로이동
            Queue<Point> qu = new LinkedList<>();
            visit[0][x1][y1] = true;
            visit[1][x1][y1] = true;
            for (int d = 1; d < 5; d++) { // 처음에 4방으로 탐색해서 넣기
                int nx = x1+di[d];
                int ny = y1+dj[d];
                if( nx < 0 || nx > 200 || ny < 0 || ny >200) continue;
                int m = 0; // 가로
                if(d%2 != 0){
                    m=1; // 세로
                }
                qu.add(new Point(nx, ny, d));
                visit[m][nx][ny] = true;
            }
            dist = 1; // 한칸 이동후 시작하므로
            boolean finish = false;
            while (!qu.isEmpty() && !finish){
                int size = qu.size();
                for (int s = 0; s < size; s++) {
                    Point now = qu.poll();
                    if(now.x == x2 && now.y == y2) {
                        finish = true;
                        ans = dist;
                        break;
                    }
                    if(now.d%2 != 0){ // 홀수방향 (상, 하)
                        for (int dir = 2; dir < 5; dir+=2) {
                            int ny = now.y + dj[dir];
                            if( ny < 0 || ny >200 || visit[0][now.x][ny] ) continue; // 범위 밖이던가 방문했던가
                            qu.add(new Point(now.x, ny, dir));
                            visit[0][now.x][ny] = true;
                        }
                    }else{ // 짝수방향 (좌, 우)
                        for (int dir = 1; dir < 5; dir+=2) {
                            int nx = now.x + di[dir];
                            if( nx < 0 || nx > 200  || visit[1][nx][now.y]) continue;
                            qu.add(new Point(nx, now.y, dir));
                            visit[1][nx][now.y] = true;
                        }
                    }
                }
                dist++; // 거리증가
            }

            System.out.println("#"+TC+" "+ans);
        }
    }

    static class Point{
        int x, y, d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
