package day0825;

import java.util.Arrays;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int len = sizes.length;
        int[] row = new int[len]; // 큰수
        int[] col = new int[len]; // 작은수

        for(int i=0; i<len; i++){
            if(sizes[i][0] >= sizes[i][1]){
                row[i] = sizes[i][0];
                col[i] = sizes[i][1];
            } else {
                row[i] = sizes[i][1];
                col[i] = sizes[i][0];
            }
        }

        Arrays.sort(row);
        Arrays.sort(col);
        answer = row[len-1] * col[len-1];
        return answer;
    }
}
