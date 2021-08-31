package test;

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
        ans = new HashSet<>(); // c의 값을 중복 제거 후 넣기
        C = new ArrayList<>(); // set에 있는 값을 넣어서 정렬 후 출력 할 것임
        visit = new boolean[a][b][c]; // 용량이 맞는 부분에 방문체크
        visit[0][0][c] = true; // 시작상태 체크
        bfs(0, 0, c);

    }

    static void bfs(int na, int nb, int nc){
        // a-> b
        if(na+nb >= b){
            // na (b-nb)
        }

        // a-> c

        // b-> a

        // b-> c

        // c-> a

        // c-> b

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
