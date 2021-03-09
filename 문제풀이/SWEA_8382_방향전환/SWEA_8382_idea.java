package day1203;

import java.util.Scanner;

public class SWEA_8382_2 {
    static int stX;
    static int stY;
    static int goX;
    static int goY;
    static int MIN;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int tc = 1; tc <= testCase; tc++) {
            stX = sc.nextInt();//초기 x
            stY = sc.nextInt();//초기 y
            goX = sc.nextInt();//도착지 x
            goY = sc.nextInt();//도착지 y

            MIN = Integer.MAX_VALUE;

            solve(true);
            solve(false); // 방향 가로세로 둘다 고려하자.
            System.out.println("#" + tc +" " + MIN);
        }
        sc.close();
    }
    private static void solve(boolean dir) {
        int dx = stX;
        int dy = stY;
        int count = 0;
        while(true) {
            if(dx==goX && dy ==goY) {
                if(MIN > count) MIN = count;
                break;
            }
            if(dir) {//이전 방향이 무엇이냐에 따라
                if(dy > goY) dy--;
                else dy++;
                dir = false; //방향을 다시 바꿔줘야한다.
            }
            else {//세로로
                if(dx > goX) dx--;
                else dx++;
                dir = true;
            }
            count++;//횟수가 늘었으니 일단 늘리자.
        }
    }
}