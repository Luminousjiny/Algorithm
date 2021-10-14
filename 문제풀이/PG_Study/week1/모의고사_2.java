package study_week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 모의고사_2 {
    public static void main(String[] args) {
        int[] z = {1,3,2,4,2};
        ArrayList<Integer> arr = solution(z);
        for (int x:arr) {
            System.out.print(x+" ");
        }
    }
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] check = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}}; // 5, 8, 10
        int[][] memory = new int[check.length][2]; // 번호, cnt

        for (int i = 0; i < check.length; i++) {
            int cnt = 0;
            int idx = 0;
            for (int j = 0; j < answers.length; j++) { // 정답입력 배열 돌면서 내가 쓴 정답 배열 돌기
                if(answers[j] == check[i][idx]) cnt++;
                idx++;
                if(idx==check[i].length) idx = 0;
            }
            memory[i][0] = i+1; // 번호
            memory[i][1] = cnt; // 개수
        }
        int max = Math.max(Math.max(memory[0][1], memory[1][1]), memory[2][1]);
        for (int i = 0; i < memory.length; i++) {
            if (max == memory[i][1]) answer.add(memory[i][0]);
        }
        Collections.sort(answer);
        return answer;
    }
}
