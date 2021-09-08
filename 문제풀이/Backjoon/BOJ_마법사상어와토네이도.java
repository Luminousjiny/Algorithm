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

        int[][] spread1 = {{0,0,2,0},{0,10,7,1},{5,55,0,0},{0,10,7,1},{0,0,2,0}};
        int[][] spread2 = {{0,1,0,1,0},{2,7,0,7,2},{0,10,55,10,0},{0,0,5,0,0}};
        int[][] spread3 = {{0,2,0,0},{1,7,10,0},{0,0,55,5},{1,7,10,0},{0,2,0,0}};
        int[][] spread4 = {{0,0,5,0,0},{0,10,55,10,0},{2,7,0,7,2},{0,1,0,1,0}};

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
                        for (int k = 0; k < 5; k++) {
                            for (int l = 0; l < 4; l++) {
                                if(spread1[k][l] != 0){
                                    int plus = (int) (map[sx][sy] * spread1[k][l] * 0.01);
                                    map[k+sx-2][l+sy-3] += plus; // spread1[k][l] 숫자의 비율 더해줌
                                }
                            }
                        }
                        map[nx][ny] = 0; // 이동한 자리는 0 ... 토네이도로 다 뿌려짐
                    }else if(dir == 1){
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if(spread2[k][l] != 0){
                                    int plus = (int) (map[sx][sy] * spread2[k][l] * 0.01);
                                    map[k+sx][l+sy-2] += plus; // spread2[k][l] 숫자의 비율 더해줌
                                }
                            }
                        }
                        map[nx][ny] = 0; // 이동한 자리는 0 ... 토네이도로 다 뿌려짐
                    }else if(dir == 2){
                        for (int k = 0; k < 5; k++) {
                            for (int l = 0; l < 4; l++) {
                                if(spread3[k][l] != 0){
                                    int plus = (int) (map[sx][sy] * spread3[k][l] * 0.01);
                                    map[k+sx-2][l+sy] += plus; // spread3[k][l] 숫자의 비율 더해줌
                                }
                            }
                        }
                        map[nx][ny] = 0; // 이동한 자리는 0 ... 토네이도로 다 뿌려짐
                    }else if(dir == 3){
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if(spread4[k][l] != 0){
                                    int plus = (int) (map[sx][sy] * spread4[k][l] * 0.01);
                                    map[k+sx-3][l+sy-2] += plus; // spread4[k][l] 숫자의 비율 더해줌
                                }
                            }
                        }
                        map[nx][ny] = 0; // 이동한 자리는 0 ... 토네이도로 다 뿌려짐
                    }
                }
                sx = nx; sy = ny; // 시작점 바꾸기
            }
            dir = (dir+1)%4; // 방향의 이동이 끝나면 방향 전환
        }
        System.out.println(ANS);
    }
}
