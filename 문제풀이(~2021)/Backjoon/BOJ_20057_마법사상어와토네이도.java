package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {
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

        int[] percent = {1,1,2,2,7,7,10,10,5};
        int[][] spreadX = {{-1,1,-2,2,-1,1,-1,1,0}, {-1,-1,0,0,0,0,1,1,2}, {-1,1,-2,2,-1,1,-1,1,0}, {1,1,0,0,0,0,-1,-1,-2}};
        int[][] spreadY = {{1,1,0,0,0,0,-1,-1,-2}, {-1,1,-2,2,-1,1,-1,1,0}, {-1,-1,0,0,0,0,1,1,2}, {-1,1,-2,2,-1,1,-1,1,0}};

        int sx = N/2; int sy = N/2; // 가운데 부터 시작
        int dir = 0;
        for (int i = 0; i < moveCnt.length; i++) {
            int move = moveCnt[i]; // 이동할 횟 수
            if(sx == 0 && sy == 0 ) break;
            for (int j = 0; j < move; j++) {
//                print();

                int nx = sx + di[dir];
                int ny = sy + dj[dir];
                int rest = map[nx][ny];
                // 이동한 자리에서 a와 %로 퍼진 부분에 모래 더해주기, 이동한 자리는 0으로 세팅
                for (int l = 0; l < 9; l++) {
                    int px = nx + spreadX[dir][l];
                    int py = ny + spreadY[dir][l];
                    int plus = (int) (map[nx][ny] * percent[l] / 100);
                    if(px<0 || px>=N || py<0 || py>=N) ANS += plus;
                    else map[px][py] += plus;
                    rest -= plus; // 퍼진 것 빼주기
                }
                if(nx+di[dir]<0 || nx+di[dir]>=N || ny+dj[dir]<0 || ny+dj[dir]>=N) ANS += rest;
                else map[nx+di[dir]][ny+dj[dir]] += rest; // 남은 것 a에 더해주기
                map[nx][ny] = 0; // 이동한 자리는 0 ... 토네이도로 다 뿌려짐
                sx = nx; sy = ny; // 시작점 바꾸기
            }
            dir = (dir+1)%4; // 방향의 이동이 끝나면 방향 전환
        }
        System.out.println(ANS);
    }

//    private static void print() {
//        System.out.println("**************");
//        for (int[] row : map) {
//            for (int v : row) {
//                System.out.print(v + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("**************");
//    }
}

