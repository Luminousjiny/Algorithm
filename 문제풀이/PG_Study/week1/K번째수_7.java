package PG_codingTestStudy;

import java.util.Arrays;

public class K번째수_7 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int n=0; n<commands.length; n++){
            int start = commands[n][0];
            int end = commands[n][1];
            int k = commands[n][2];
            int[] cut = new int[end-start+1];
            for(int i=0; i<cut.length; i++){
                cut[i] = array[i+start-1];
            }
            Arrays.sort(cut);
            answer[n] = cut[k-1];
        }
        return answer;
    }
}
