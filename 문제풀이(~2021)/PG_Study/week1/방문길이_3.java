package PG_codingTestStudy;

import java.util.ArrayList;

// week1
public class 방문길이_3 {
    public static void main(String[] args) {
        int ans = solution("LULLLLLLU");
        System.out.println(ans);
    }
    static int[] di = {-1, 0, 0, 1}; // ULRD
    static int[] dj = {0, -1, 1, 0};
    public static int solution(String dirs) {
        int answer = 0;

        ArrayList<Integer>[][] map = new ArrayList[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        int sx = 5; int sy = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char nowDir = dirs.charAt(i);
            int dir = 0; // U
            if(nowDir == 'L') dir = 1;
            else if(nowDir == 'R') dir = 2;
            else if(nowDir == 'D') dir = 3;

            int nx = sx + di[dir];
            int ny = sy + dj[dir];
            if(nx<0 || nx >=11 || ny<0 || ny >=11) continue;
            boolean check = false;
            if(map[nx][ny].size() != 0){ // 누군가 지나갔다면 어느 방향에서 왔었는지 확인
                for (int j = 0; j < map[nx][ny].size(); j++) {
                    if(map[nx][ny].get(j) == dir) check = true;
                }
                if(!check) answer++; // 같은 방향에서 온 적이 없으면 처음 온 길
            }else{ // 한번도 안온 정점이면 처음 온 길
                answer++;
            }
            map[nx][ny].add(dir);
            map[sx][sy].add(3-dir);
            sx = nx; sy = ny;
        }
        return answer;
    }
}
