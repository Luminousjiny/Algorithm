package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_마법사상어와토네이도 {
    static StringTokenizer st;
    static int N, ANS;
    static int[][] map;
    static int[] moveCnt;
    static int[] di = {0,1,0,-1};
    static int[] dj = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        moveCnt = new int[2*N-1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num = 1;
        for (int i = 0; i < moveCnt.length-1; i+=2) {
            moveCnt[i] = moveCnt[i+1] = num;
            num++;
        }
        moveCnt[2*N-2] = N-1;

        int sx = N/2+1; int sy = N/2+1; // 가운데 부터 시작
        int dir = 0;
        for (int i = 0; i < moveCnt.length; i++) {
            int move = moveCnt[i]; // 이동할 횟 수
            for (int j = 0; j < move; j++) {
                int nx = sx + di[dir];
                int ny = sy + dj[dir];
                if(nx<0 || nx>=N || ny<0 || ny>=N){
                    ANS += map[sx][sy]; // 덩어리로 나간거 더해주기
                }else{  // 이동한 자리에서 a와 %로 퍼진 부분에 모래 더해주기, 이동한 자리는 0으로 세팅
                    if(dir == 0){

                    }else if(dir == 1){

                    }else if(dir == 2){

                    }else if(dir == 3){

                    }
                }
                sx = nx; sy = ny; // 시작점 바꾸기
            }
            dir = (dir+1)%4; // 방향의 이동이 끝나면 방향 전환
        }
        System.out.println(ANS);
    }
}
