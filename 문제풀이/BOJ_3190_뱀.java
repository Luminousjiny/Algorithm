import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class BOJ_3190_뱀 {
    static StringTokenizer st;
    static int N, K, L;
    static int[][] map; //뱀 이동판
    static Dir[] dir; //시간, 방향배열
    static List<Point> snake;//1
    static int time, movedir, ansdir;
    static int[] di= {0, 1, 0 , -1};
    static int[] dj= {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map[R][C] = 5; // 사과 자리
        }
        L = Integer.parseInt(br.readLine());
        dir = new Dir[L]; // 시간, 방향 저장 배열
        for (int l = 0; l < L; l++) { // 0 , 1, 2, 3
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            String D = st.nextToken();
            dir[l] = new Dir(T, D);
        }
        movedir = 0; // 오른쪽으로 시작  , 방향은 머리만 고려해주기
        snake = new LinkedList<>(); // 뱀이 있는 좌표 저장 큐
        snake.add(new Point(1,1)); //시작점 넣기
        int i = 0; // dir 배열길이 체크
        while (true){
            time++; // 시간 증가
            // movedir  방향으로 이동
            Point now = snake.get(snake.size()-1);
            int ni = now.x + di[movedir];
            int nj = now.y + dj[movedir];
            // 맵의 바깥이거나 , 리스트에 있는 좌표이면 그 때의 시간 출력 끝
            boolean out = false;
            if(ni<1 || ni >N || nj<1 || nj>N ){ // 범위 밖
                out = true;
            }
            if(out) break;
            for (int point = 0; point < snake.size(); point++) {
                if (snake.get(point).x == ni && snake.get(point).y == nj) {
                    out = true;
                }
            }
            if(out) break;
            if(map[ni][nj] == 5){// 사과가 있는 자리이면 이동한 자리만 넣어줌
                snake.add(new Point(ni,nj));
                map[ni][nj] = 0;
            }else{ //사과가 없는 자리이면
                snake.add(new Point(ni, nj)); //이동한 자리 넣어주고,
                snake.remove(0); //리스트의 가장 처음 들어간 자리 remove(꼬리 잘름)
            }
            if(i < dir.length && time == dir[i].X){ // 방향바꿀 시간임
                movedir = makedir(movedir, dir[i].C); //방향 바꿔주기
                i++;
            }
        }//while
        System.out.println(time);
    }
    static class Dir{
        int X;
        String C;
        Dir(int X, String C){
            this.X = X;
            this.C = C;
        }
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    // 방향 변경
    static int makedir(int dr, String DL){ //현재 이동하고있는 방향, 이동할 방향의 문자
        // 우, 하, 좌, 상  (0,1,2,3)
        if(dr == 0){ //오른쪽이고
            if(DL.equals("D")){ // D이면
                ansdir = 1;
            }else{ // L이면
                ansdir = 3;
            }
        }else if(dr == 1){ // 아래이고
            if(DL.equals("D")){ // D이면
                ansdir = 2;
            }else{ // L이면
                ansdir = 0;
            }
        }else if(dr == 2){ // 왼쪽이고
            if(DL.equals("D")){ // D이면
                ansdir = 3;
            }else{ // L이면
                ansdir = 1;
            }
        }else if(dr == 3){ //위로가고
            if(DL.equals("D")){ // D이면
                ansdir = 0;
            }else{ // L이면
                ansdir = 2;
            }
        }
        return ansdir;
    }
}