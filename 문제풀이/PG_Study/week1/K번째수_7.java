package PG_codingTestStudy;

import java.util.Arrays;

public class K번째수_7 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int n=0; n<commands.length; n++){
            int start = commands[n][0];
            int end = commands[n][1];
            int k = commands[n][2];
            int[] cut = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(cut);
            answer[n] = cut[k-1];
        }
        return answer;
    }
}
