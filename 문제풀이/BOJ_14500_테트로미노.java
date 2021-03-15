import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int N, M, MAX;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visit;
    static int[] di ={-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dj ={0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        MAX = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                DFS(i, j, 1, map[i][j]); // 시작점으로부터 dfs
                Block(i, j);// + 모양으로 탐색하여 상 하 좌 우 중 최소값 빼기
                visit[i][j] = false;
            }
        }
        System.out.println(MAX);
    }

    private static void DFS(int sx, int sy, int size, int sum) {
        if(size == 4){ // 4개가 되면 max값 갱신
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = sx + di[dir];
            int ny = sy + dj[dir];
            // map 내부이고, 방문하지 않았고, 아직 길이가 4가 아니면 dfs()
            if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny]) {
                visit[nx][ny] = true;
                DFS(nx, ny, size + 1, sum + map[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

    private static void Block(int sx, int sy) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int sum = map[sx][sy];
        for (int dir = 0; dir < 4; dir++) {
            int nx = sx + di[dir];
            int ny = sy + dj[dir];
            if(nx<0 || nx >=N || ny<0 || ny >= M)continue;
            sum += map[nx][ny]; // 값 누적
            min = Math.min(min, map[nx][ny]); // 사방 중 최소값 저장
            count++;
        }
        if(count == 4) {
            sum -= min;
            MAX = Math.max(MAX, sum); // 갱신
        }else if(count == 3){
            MAX = Math.max(MAX, sum); // 갱신
        }
    }

}
