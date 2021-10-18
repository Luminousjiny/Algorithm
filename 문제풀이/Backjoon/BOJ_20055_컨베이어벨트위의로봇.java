package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
    static StringTokenizer st;
    static int N, K;
    static int[] map, robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[2*N]; // 내구도 숫자 표시
        robot = new int[2*N]; // 로봇 표시 -> 인덱스로 표시
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int rid = 1; // 로봇 번호
        int lound = 1;
        while (true){
            // 1. map, robot 한 칸씩 회전
            int m_tmp = map[2*N-1];
            int r_tmp = robot[2*N-1];
            for (int i = 2*N-2; i >=0 ; i--) {
                map[i+1] = map[i];
                robot[i+1] = robot[i];
            }
            map[0] = m_tmp;
            robot[0] = r_tmp;
            robot[N-1] = 0;

            // 2. robot에 기록된 rid가 작은 칸부터 회전 방향으로 이동
            int id = 2*N-2;
            int tmp2 = robot[id+1];
            while (id >= 0){
                if(robot[id] != 0 && robot[id+1] == 0 && map[id+1] >= 1){
                    robot[id+1] = robot[id];
                    robot[id] = 0;
                    map[id+1]--;
                }
                id--;
            }
            robot[0] = tmp2;
            robot[N-1] = 0;

            // 3. 내구도 감소하고, 로봇 기록
            if(map[0] !=0 && robot[0] == 0){
                robot[0] = rid;
                map[0]--;
            }
            rid++;

            // 4. 내구도 == 0 이면, cnt++;
            // cnt >= K 이면 종료, 아니면 다시 1번
            int cnt = 0;
            for (int i = 0; i < 2*N; i++) {
                if(map[i] == 0) cnt++;
            }
            if(cnt >= K) break;
            lound++;
        }
        System.out.println(lound);
    }
}
