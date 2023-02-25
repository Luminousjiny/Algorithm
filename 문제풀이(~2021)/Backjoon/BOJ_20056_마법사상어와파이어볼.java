package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// map에 ball의 개수를 기록하고, ballList를 따로 관리하는 방법 => 시간초과..
// map 한칸을 list로 생성해서 모든 ballList를 돌지말고
// 그 칸의 ballList만 돌면서 확인하도록 수정 -> 해결

public class BOJ_20056_마법사상어와파이어볼 {
    static StringTokenizer st;
    static int N, M, K, ANS;
    static ArrayList<Ball>[][] map;
    static Queue<Ball> ballList;
    static int[] di = {-1,-1,0,1,1,1,0,-1};
    static int[] dj = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        ballList = new LinkedList<>();
        for (int i = 0; i < M; i++) { // 처음 공 위치 표시
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            ballList.add(new Ball(r-1, c-1, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            int s = ballList.size();
            // 1번부터 N번까지 이동
            for (int size = 0; size < s; size++) {
                Ball now = ballList.poll();

                int sr = now.r; int sc = now.c;
                int nr = sr + di[now.d] * now.s % N;
                int nc = sc + dj[now.d] * now.s % N;
                if(nr >= N ) nr -= N;
                if(nr < 0 ) nr += N;
                if(nc >= N ) nc -= N;
                if(nc < 0 ) nc += N;
                map[nr][nc].add(new Ball(nr, nc, now.m, now.s, now.d));
            }
            // 이동하고 2개이상이면 같은 칸에 4개로 만들어주기
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k].size() == 1) {
                        ballList.add(map[j][k].get(0));
                    }
                    else if(map[j][k].size() >= 2){
                        int cnt = map[j][k].size(); int mSum = 0; int sSum = 0;
                        int dirL = 0; int dirR = 0;
                        for (int l = 0; l < cnt; l++){
                            mSum += map[j][k].get(l).m;
                            sSum += map[j][k].get(l).s;
                            if(map[j][k].get(l).d % 2 == 0) dirL++;
                            else dirR++;
                        }

                        if(mSum/5 != 0){
                            if(dirL == 0 || dirR == 0){
                                for (int dir = 0; dir < 8; dir+=2) {
                                    ballList.add(new Ball(j, k, mSum/5, sSum/cnt,dir));
                                }
                            }else {
                                for (int dir = 1; dir < 8; dir += 2) {
                                    ballList.add(new Ball(j, k, mSum / 5, sSum / cnt, dir));
                                }
                            }
                        }
                    }
                    map[j][k].clear();
                }
            }
        }
        for (Ball ball:ballList) {
            ANS += ball.m;
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
}