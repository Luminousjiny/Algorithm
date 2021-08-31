import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2251_물통 {
    static int a, b, c;
    static Queue<Bucket> qu;
    static Set<Integer> ans;
    static ArrayList<Integer> C;
    static boolean[][][] visit;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        qu = new LinkedList<>(); // a,b,c 물의 양을 class로 넣기
        ans = new HashSet<>(); // c의 값을 중복 제거 후 넣기
        C = new ArrayList<>(); // set에 있는 값을 넣어서 정렬 후 출력 할 것임
        visit = new boolean[a+1][b+1][c+1]; // 용량이 맞는 부분에 방문체크
        visit[0][0][c] = true; // 시작상태 체크
        qu.add(new Bucket(0,0,c));
        ans.add(c);
        while (!qu.isEmpty()){
            Bucket now = qu.poll();
            // a-> b
            if(now.x+now.y >= b && !visit[now.x-(b- now.y)][b][now.z]){ // a와 b 물통에 있는 물의 합이 b 크기보다 크면
                qu.add(new Bucket(now.x-(b- now.y), b, now.z)); // b를 꽉 채우고 남는게 있다면 a로
                visit[now.x-(b- now.y)][b][now.z] = true; // 방문체크
                ans.add(now.z);
            }else if(now.x+now.y < b && !visit[0][now.y+ now.x][now.z]){ // a와 b 물통에 있는 물의 합이 b 크기보다 작으면
                qu.add(new Bucket(0, now.y+ now.x, now.z)); // a+b 물의 합을 b에 모두 넣기
                visit[0][now.y+ now.x][now.z] = true; // 방문체크
                ans.add(now.z);
            }

            // a-> c
            if(now.x+now.z >= c && !visit[now.x-(c- now.z)][now.y][c]){
                qu.add(new Bucket(now.x-(b- now.y), now.y, c));
                visit[now.x-(c- now.z)][now.y][c] = true;
                ans.add(c);
            }else if(now.x+now.z < c && !visit[0][now.y][now.x+now.z]){
                qu.add(new Bucket(0, now.y, now.x+now.z));
                visit[0][now.z][now.x+now.z] = true;
                if(now.x + now.z != 0) ans.add(now.x+now.z);
            }

            // b-> a
            if(now.y+now.x >= a && !visit[a][now.y-(a-now.x)][now.z]){
                qu.add(new Bucket(a, now.y-(a-now.x), now.z));
                visit[a][now.y-(a-now.x)][now.z] = true;
                if(now.z != 0) ans.add(now.z);
            }else if(now.y+now.x < a && !visit[now.x+now.y][0][now.z]){
                qu.add(new Bucket(now.y+now.x, 0, now.z));
                visit[now.x+now.y][0][now.z] = true;
                if(now.z != 0) ans.add(now.z);
            }

            // b-> c
            if(now.y+now.z >= c && !visit[now.x][now.y-(c-now.z)][c]){
                qu.add(new Bucket(now.x, now.y-(c-now.z), c));
                visit[now.x][now.y-(c-now.z)][c] = true;
                ans.add(c);
            }else if(now.y+now.z < c && !visit[now.x][0][now.z+now.y]){
                qu.add(new Bucket(now.x, 0, now.y+now.z));
                visit[now.x][0][now.z+now.y] = true;
                if(now.z+now.y != 0) ans.add(now.z+now.y);
            }
            // c-> a
            if(now.z+now.x >= a && !visit[a][now.y][now.z-(a-now.x)]){
                qu.add(new Bucket(a, now.y, now.z-(a-now.x)));
                visit[a][now.y][now.z-(a-now.x)] = true;
                if(now.z-(a-now.x) != 0) ans.add(now.z-(a-now.x));
            }else if(now.z+now.x < a && !visit[now.x+now.z][now.y][0]){
                qu.add(new Bucket(now.z+now.x, now.y, 0));
                visit[now.x+now.z][now.y][0] = true;
            }

            // c-> b
            if(now.z+now.y >= b && !visit[now.x][b][now.z-(b-now.y)]){
                qu.add(new Bucket(now.x, b, now.z-(b-now.y)));
                visit[now.x][b][now.z-(b-now.y)] = true;
                if(now.z-(b-now.y) != 0) ans.add(now.z-(b-now.y));
            }else if(now.z+now.y < b && !visit[now.x][now.y+now.z][0]){
                qu.add(new Bucket(now.x, now.y+now.z, 0));
                visit[now.x][now.y+now.z][0] = true;
            }
        }
        for (int x:ans) {
            C.add(x);
        }
        Collections.sort(C);
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i)+" ");
        }
    }

    static class Bucket{
        int x, y, z;
        Bucket(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
