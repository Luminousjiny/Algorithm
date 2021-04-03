package programmers.카카오커머스;

import java.util.ArrayList;

public class Solution2 {
    public static void main(String[] args) {
        int[][] needs = { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} };
        int ans = solution(needs, 2);
        System.out.println(ans);
    }
    static int Max;
    public static int solution(int[][] needs, int r) {
        int answer = 0;
        ArrayList<Integer> part = new ArrayList<>(); // 필요한 부품 번호 담김

        int[] Row = needs[0];
        boolean[] select = new boolean[Row.length];

        for (int i = 0; i < needs.length; i++) {
            int[] nowRow = needs[i];
            for (int j = 0; j < nowRow.length; j++) {
                if(!select[j] && nowRow[j] == 1) {
                    part.add(j);
                    select[j] = true;
                }
            }
        }

        int size = part.size();
        int[] Part = new int[size];
        for (int i = 0; i < size; i++) {
            Part[i] = part.get(i);
        }

        int[] com = new int[r];
        int count = 0;
        comb(0, 0, r, Part, com, needs, count);
        answer = Max;
        return answer;
    }

    public static void comb(int cnt, int cur, int r, int[] part, int[] com, int[][] needs, int count) {
        if(cnt == r){
            for (int i = 0; i < needs.length; i++) {
                int[] nowRow = needs[i];
                ArrayList<Integer> arr = new ArrayList<>();
                for (int j = 0; j < nowRow.length; j++) {
                    if(nowRow[j] == 1) arr.add(j);
                }
                int size = arr.size();
                boolean[] ck = new boolean[size];
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < com.length; k++) {
                        if(arr.get(j) == com[k]) ck[j] = true;
                    }
                }
                for (int j = 0; j < size; j++) {
                    System.out.print(ck[j]+" ");
                }
                System.out.println();
                boolean right = true;
                for (int j = 0; j < size; j++) {
                    if(!ck[j]) {
                        right = false;
                    }
                }
                if(right) {
                    count++;
                }
            }
            Max = Math.max(Max, count);
            return;
        }
        for (int i = cur; i < part.length; i++) {
            com[cnt] = part[i];
            comb(cnt+1, i+1, r, part, com, needs, count);
        }
    }

}
