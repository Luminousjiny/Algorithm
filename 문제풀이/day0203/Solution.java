import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int N, time;
	static int[][] map;
	static boolean[][][] visit;
	static Point[] exit;
	static ArrayList<Point> person;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1}; // 상 하 좌 우
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int T = 1; T <= TC; T++) {
			N = Integer.parseInt(br.readLine()); 
			map = new int[N][N];
			person = new ArrayList<>();
			exit = new Point[2]; // 비상구 2개 저장
			int id = 0, pNum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					if(n == 1) { // 사람이면
						pNum++;
						map[i][j] = pNum;
						person.add(new Point(i, j, pNum)); // 사람좌표 저장
					}
					if(n == 2) { // 비상구 좌표 저장
						map[i][j] = -1;
						exit[id] = new Point(i, j, -1);
						id++;
					}
				}
			}// map 채우기
			
			time = 0; 
			visit = new boolean [N][N][pNum+1]; // 각 사람을 따로 방문처리 할 것
			Queue<Point> qu = new LinkedList<>();
			for (int i = 0; i < person.size(); i++) {
				int ix = person.get(i).x;
				int iy = person.get(i).y;
				qu.add(new Point(ix, iy, i+1));
				visit[ix][iy][i+1] = true; // 그 사람의 방문 배열에 방문체크
			} // 사람들 시작점 큐에 넣기
			int outCnt = 0;
			boolean ck = false;
			boolean[] outList = new boolean[pNum+1];
			while(!qu.isEmpty()) {
				int size = qu.size();
				boolean out = false, out2 = false; // 사이즈 당 한명만 나갈 수 있음
				for (int s = 0; s < size; s++) {
					Point now = qu.poll();
					if((now.x == exit[0].x && now.y == exit[0].y)) { // 1번 비상구면
						if(!out) { // 이번턴에 아무도 안나감
							if(!outList[now.pNum]) { // 난 나간적 없어
								out = true; 
								outList[now.pNum] = true; // 나감 체크 
								outCnt++;
							}
						}else qu.add(now); // 이번턴에 누가 나가서 다시 들어가 못나가

						if(outCnt == pNum) { // 나간사람이 사람수랑 같으면 끝
							ck = true; // while문 종료해도된다는 말 
							break;
						}
					}else if((now.x == exit[1].x && now.y == exit[1].y)) { // 2번 비상구면
						if(!out2) { // 이번턴에 아무도 안나감
							if(!outList[now.pNum]) { // 난 나간적 없어
								out2 = true; 
								outList[now.pNum] = true; // 나감 체크 
								outCnt++;
							}
						}else qu.add(now); // 이번턴에 누가 나가서 다시 들어가 못나가

						if(outCnt == pNum) { // 나간사람이 사람수랑 같으면 끝
							ck = true; // while문 종료해도된다는 말 
							break;
						}
					}else { // 비상구가 아니면 방향 고고
						for (int dir = 0; dir < 4; dir++) {
							int nx = now.x + di[dir];
							int ny = now.y + dj[dir];
							
							if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny][now.pNum]) { // 이동한 좌표가  map 내부
								qu.add(new Point(nx, ny, now.pNum));
								visit[nx][ny][now.pNum] = true;
							} // 조건
						}// dir
					}
					
				}// size
				time++;
				if(ck) break;
			}
			
			System.out.println("#"+T+" "+time);
		} // TC
	}
	
	static class Point{
		int x, y, pNum;
		Point(int x, int y, int pNum){
			this.x = x;
			this.y = y;
			this.pNum = pNum;
		}
	}

}
