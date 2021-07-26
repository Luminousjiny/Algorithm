import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
    static StringTokenizer st;
    static int N, M, MAX;
    static int[][] map, mapTest;
    static ArrayList<Point> walls, virus; // 빈칸 / 바이러스 좌표저장
    static int[] combRes;
    static int[] di = {-1, 1, 0, 0}; // 상하좌우
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        map = new int[N][M];
        mapTest = new int[N][M];
        walls = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n == 0) walls.add(new Point(i, j));
                else if(n == 2) virus.add(new Point(i, j));
            }
        }
        MAX = Integer.MIN_VALUE;

        combRes = new int[3];
        comb(0, 0);
        System.out.println(MAX);
    }
    static void comb(int cnt, int cur){
        if(cnt == 3){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    mapTest[i][j] = map[i][j];
                }
            }
            // 벽세우기
            for (int i = 0; i < 3; i++) {
                Point wall = walls.get(combRes[i]); // 리스트 중 조합된 인덱스로 뽑힌 좌표
                mapTest[wall.x][wall.y] = 1; // 벽세우기
            }
            BFS();
            return;
        }
        for (int i = cur; i < walls.size(); i++) {
            combRes[cnt] = i; // 인덱스 조합
            comb(cnt +1, i +1);
        }
    }
    static void BFS(){ // 바이러스 퍼지기 - bfs
        Queue<Point> qu = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            qu.add(virus.get(i));
        }
        while (!qu.isEmpty()){
            Point now = qu.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + di[dir];
                int ny = now.y + dj[dir];
                if(nx <0 || nx >=N || ny <0 || ny>=M || mapTest[nx][ny] != 0 ) continue; // 범위 밖, 빈칸 아니면
                mapTest[nx][ny] = 2; // 바이러스 전염
                qu.add(new Point(nx, ny)); // qu에 추가
            }
        }
        // 0인 칸 개수 세기
        int count = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if(mapTest[j][k] == 0) count++;
            }
        }
        MAX = Math.max(MAX, count); // MAX 갱신
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}