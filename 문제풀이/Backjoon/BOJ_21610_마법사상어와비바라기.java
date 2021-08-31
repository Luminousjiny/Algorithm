package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {
    static int ANS;
    static StringTokenizer st;
    static boolean[][] cloud;
    static int[] di = {0, 0,-1,-1,-1,0,1,1,1};
    static int[] dj = {0, -1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1]; // 바구니 숫자 표시
        int[][] go = new int[M][2];

        // 입력된 바구니 기록
       for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       // 이동 방향, 시간 입력 기록
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                go[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> qu = new LinkedList<>(); // 매 이동마다 이동할 구름좌표 저장
        Queue<Point> check = new LinkedList<>(); // 이동 후 좌표값 저장
        qu.add(new Point(N,1));
        qu.add(new Point(N,2));
        qu.add(new Point(N-1,1));
        qu.add(new Point(N-1,2));

        // M번의 이동 시작
        for (int i = 0; i < M; i++) {
            cloud = new boolean[N+1][N+1]; // 구름이 있다가 없어진 자리 체크
            int nowDir = go[i][0];
            int nowTime = go[i][1];
            while (!qu.isEmpty()){
                Point now = qu.poll();
                int nx = now.x; int ny = now.y;
                for (int j = 0; j < nowTime; j++) {
                    nx += di[nowDir];
                    ny += dj[nowDir];
                    if(nx > N) nx = 1;
                    if(ny > N) ny = 1;
                    if(nx < 1) nx = N;
                    if(ny < 1) ny = N;
                }
                map[nx][ny]++; // 바구니 물 증가
                cloud[nx][ny] = true; // 비구름 없어질 자리
                check.add(new Point(nx, ny));
            } // 모든 좌표 이동 완료

            while (!check.isEmpty()){
                Point now = check.poll();
                int cnt = 0;
                for (int dir = 2; dir <= 8; dir+=2) {
                    int nx = now.x + di[dir];
                    int ny = now.y + dj[dir];
                    if(nx<1 || nx>N || ny<1 || ny>N) continue;
                    if(map[nx][ny] != 0) cnt++;
                }
                map[now.x][now.y] += cnt;
            } // 이동된 좌표에서 대각선 탐색

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(map[j][k] >= 2 && !cloud[j][k]){
                        qu.add(new Point(j,k)); // 구름 생성
                        map[j][k] -= 2;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j] != 0){
                    ANS += map[i][j];
                }
            }
        }
        System.out.println(ANS);
    }

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
