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
        System.out.println("초기 상태");
        print();

        for (int i = 0; i < K; i++) {
            for (int size = 0; size < ballList.size(); size++) {
                Ball now = ballList.poll();
                int sr = now.r; int sc = now.c;
                map[sr][sc]--;
                for (int j = 0; j < now.s; j++) {
                    int nr = sr + di[now.d];
                    int nc = sc + dj[now.d];
                    if(nr >= N ) nr = 0;
                    if(nr < 0 ) nr = N-1;
                    if(nc >= N ) nc = 0;
                    if(nc < 0 ) nc = N-1;
                    sr = nr; sc = nc;
                }
                map[sr][sc]++;
                ballList.add(new Ball(sr, sc, now.m, now.s, now.d));
                System.out.println("이동 : "+sr +" " + sc + " " + now.m +" "+ now.s + " " + now.d);
            }

            for (Ball b:ballList) {
                System.out.println(b.r+", " + b.c+ " "+b.m);
            }

            System.out.println("이동 후");
            print();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] >= 2){
                        int cnt = map[j][k]; int mSum = 0; int sSum = 0;
                        int dirL = 0; int dirR = 0;
                        map[j][k] = 0;
                        int size = ballList.size();
                        for (int l = 0; l < size; l++) {
                            Ball ball = ballList.poll();
                            System.out.println("ball 출력 : "+ ball.r + ", "+ ball.c+" => "+ ball.m);
                            if(ball.r == j && ball.c == k){
                                mSum += ball.m;
                                sSum += ball.s;
                                if(ball.d % 2 == 0) dirL++;
                                else dirR++;
                            }else{
                                ballList.add(ball);
                            }
                            System.out.println(">>>>>>>>>들어오나");
                        }
                        System.out.println("mSum : "+mSum);
                        System.out.println("sSum : "+sSum);
                        map[j][k] = 0;
                        if(dirL == 0 || dirR == 0){
                            for (int dir = 0; dir < 8; dir+=2) {
                                int nx = j + di[dir];
                                int ny = k + dj[dir];
                                if(nx >= N ) nx = 0;
                                if(nx < 0 ) nx = N-1;
                                if(ny >= N ) ny = 0;
                                if(ny < 0 ) ny = N-1;
                                map[nx][ny]++;
                                ballList.add(new Ball(nx, ny, mSum/5, sSum/cnt,dir));
                            }
                        }else{
                            for (int dir = 1; dir < 8; dir+=2) {
                                int nx = j + di[dir];
                                int ny = k + dj[dir];
                                if(nx >= N ) nx = 0;
                                if(nx < 0 ) nx = N-1;
                                if(ny >= N ) ny = 0;
                                if(ny < 0 ) ny = N-1;
                                map[nx][ny]++;
                                ballList.add(new Ball(nx, ny, mSum/5, sSum/cnt,dir));
                            }
                        }
                    }
                }
            }
            System.out.println("2개 만날경우 퍼트리기");
            print();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0){
                    for (int k = 0; k < ballList.size(); k++) {
                        Ball ball = ballList.poll();
                        if(ball.r == i && ball.c == j){
                            System.out.println(ball.r + ", "+ ball.c+" => "+ ball.m);
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
