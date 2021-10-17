import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {
    static StringTokenizer st;
    static int N, Q, n;
    static int[][] map, copy_map;
    static int[] L;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, N);
        L = new int[Q];

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        for (int lound = 0; lound < Q; lound++) {
            copy_map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    copy_map[i][j] = map[i][j];
                }
            }
            if(L[lound] != 0){
                // 1.  map 돌리기
                int len = (int) Math.pow(2, L[lound]);

                for (int i = 0; i < n; i+=len) {
                    for (int j = 0; j < n; j+=len) {
                        turn(i, j, len); // 90도 돌리기
                    }
                }
            }

            // 2. 4방 탐색 후 개수 빼기
            ArrayList<Point> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(copy_map[i][j] != 0){
                        int zero = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = i + di[dir];
                            int ny = j + dj[dir];
                            if(nx<0 || nx>=n || ny<0 || ny>=n || copy_map[nx][ny] == 0) zero++;
                        }
                        if(zero >= 2) arr.add(new Point(i, j));
                    }
                }
            }
            for (int i = 0; i < arr.size(); i++) {
                Point now = arr.get(i);
                copy_map[now.x][now.y]--;
            }

            // 3. map <- copy_map 넣기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = copy_map[i][j];
                }
            }
        }// 라운드 끝

        // 4. BFS로 덩어리 파악 -> 덩어리 개수, 덩어리 가중치 합
        // 덩어리 가중치 합은 sum에 누적
        // 덩어리 개수가 max값보다 커지면 갱신
        // total, max 출력
        int total = 0;
        int max = 0; // 덩어리가 없으면 0
        Queue<Point> qu = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0 && !visit[i][j]){
                    int sum = map[i][j];
                    int count = 1;
                    qu.add(new Point(i, j));
                    visit[i][j] = true;
                    while (!qu.isEmpty()){
                        Point now = qu.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = now.x + di[dir];
                            int ny = now.y + dj[dir];
                            if(nx<0 || nx>=n || ny<0 || ny>=n || visit[nx][ny] || map[nx][ny] == 0) continue;
                            qu.add(new Point(nx, ny));
                            visit[nx][ny] = true;
                            sum += map[nx][ny];
                            count++;
                        }
                    }
                    total+=sum;
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(total);
        System.out.println(max);
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void turn(int sx, int sy, int len){
        for (int i = 0; i < len; i++) {
            int r = sx + i;
            int nc = len - i - 1 + sy;
            for (int j = 0; j < len; j++) {
                int c = sy + j;
                int nr = sx + j;
                copy_map[nr][nc] = map[r][c];
            }
        }
    }
}