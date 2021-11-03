package PG_codingTestStudy;

import java.util.HashMap;
import java.util.Map;

public class solution_빙고 {
    public int solution(int[][] board, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], 1);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(map.containsKey(board[i][j]))board[i][j] = 0;
            }
        }
        return check(board);
    }
    private int check(int[][] map){
        int cnt = 0;
        // 가로검사
        for(int i=0; i<map.length; i++){
            boolean row = true;
            for(int j=0; j<map.length; j++){
                if(map[i][j] != 0){
                    row = false;
                    break;
                }
            }
            if(row) cnt++;
        }
        // 세로검사
        for(int i=0; i<map.length; i++){
            boolean col = true;
            for(int j=0; j<map.length; j++){
                if(map[j][i] != 0){
                    col = false;
                    break;
                }
            }
            if(col) cnt++;
        }
        // 대각선검사 : 왼 -> 오
        boolean LR = true;
        for(int i=0; i<map.length; i++){
            if(map[i][i] !=0){
                LR = false;
                break;
            }
        }
        if(LR) cnt++;

        // 대각선검사 : 오 -> 왼
        boolean RL = true;
        for(int i=0; i<map.length; i++){
            if(map[i][map.length-1-i] !=0){
                RL = false;
                break;
            }
        }
        if(RL) cnt++;
        return cnt;
    }
}
