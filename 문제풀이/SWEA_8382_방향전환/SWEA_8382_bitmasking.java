package day1203;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 비트마스킹으로 풀이
public class SWEA_8382 { //방향 전환

	static int x1, y1, x2, y2;
	static final int HOR = 0, VER = 1;
	static int[][][] dir = {
			{{-1,0},{1,0}}, //hor
			{{0,-1},{0,1}}  //ver
	};
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1; tc<=TC; tc++) {
			
			//좌표에 100씩 더해서 음수좌표 보정
			x1 = sc.nextInt() + 100;
			y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;
			
			System.out.println("#"+tc+" "+bfs());
		}
	}
	
	private static int bfs() {
		
		Queue<Point> queue = new LinkedList<Point>();
		boolean [][][] visited = new boolean[2][201][201];
		
		visited[HOR][x1][y1] = true;
		queue.offer(new Point(x1, y1, HOR, 0));
		visited[VER][x1][y1] = true;
		queue.offer(new Point(x1, y1, VER, 0));
		
		Point curr;
		int nx, ny;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			if(curr.x == x2 && curr.y == y2) return curr.cnt;
			
			int[][] d = dir[curr.dir^1]; //현재 자신의 방향의 반대 방향으로 움직여야하므로 XOR
			for(int i = 0; i<d.length; i++) {
				nx = curr.x + d[i][0];
				ny = curr.y + d[i][1];
				if(nx >= 0 && nx <= 200 && ny >= 0 && ny <= 200 && !visited[curr.dir^1][nx][ny]) {
					visited[curr.dir^1][nx][ny] = true;
					queue.offer(new Point(nx, ny, curr.dir^1, curr.cnt+1));
				}
			}
		}
		
		return 0;
	}

	static class Point {
		int x, y;
		int dir, cnt;

		public Point(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}

}
