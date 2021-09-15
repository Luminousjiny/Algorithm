package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {
    static StringTokenizer st;
    static int N, M, K, ANS;
    static int[][] map;
    static Queue<Ball> ballList;
    static int[] di = {-1,-1,0,1,1,1,0,-1};
    static int[] dj = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ballList = new LinkedList<>();
        for (int i = 0; i < M; i++) { // 처음 공 위치 표시
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r-1][c-1]++;
            ballList.add(new Ball(r-1, c-1, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            int s = ballList.size();
            for (int size = 0; size < s; size++) {
                Ball now = ballList.poll();
                int sr = now.r; int sc = now.c;
                map[sr][sc]--;
                int nr = sr + di[now.d] * now.s % N;
                int nc = sc + dj[now.d] * now.s % N;
                if(nr >= N ) nr -= N;
                if(nr < 0 ) nr += N;
                if(nc >= N ) nc -= N;
                if(nc < 0 ) nc += N;
                map[nr][nc]++;
                ballList.add(new Ball(nr, nc, now.m, now.s, now.d));
            }
            // 이동하고 2개이상이면 같은 칸에 4개로 만들어주기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] >= 2){
                        int cnt = map[j][k]; int mSum = 0; int sSum = 0;
                        int dirL = 0; int dirR = 0;
                        map[j][k] = 0;
                        int size = ballList.size();
                        for (int l = 0; l < size; l++) {
                            Ball ball = ballList.poll();
                            if(ball.r == j && ball.c == k){
                                mSum += ball.m;
                                sSum += ball.s;
                                if(ball.d % 2 == 0) dirL++;
                                else dirR++;
                            }else{
                                ballList.add(ball);
                            }
                        }
                        map[j][k] = 4; // 4개로 나눔
                        if(dirL == 0 || dirR == 0){
                            for (int dir = 0; dir < 8; dir+=2) {
                                if(mSum/5 != 0) ballList.add(new Ball(j, k, mSum/5, sSum/cnt,dir));
                            }
                        }else{
                            for (int dir = 1; dir < 8; dir+=2) {
                                if(mSum/5 != 0) ballList.add(new Ball(j, k, mSum/5, sSum/cnt,dir));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0){
                    int s = ballList.size();
                    for (int k = 0; k < s; k++) {
                        Ball ball = ballList.poll();
                        if(ball.r == i && ball.c == j){
                            ANS += ball.m;
                        }else ballList.add(ball);
                    }
                }
            }
        }
        System.out.println(ANS);
    }

    static class Ball{
        int r, c, m, s, d;
        Ball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static void print(){
        System.out.println("-------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}
