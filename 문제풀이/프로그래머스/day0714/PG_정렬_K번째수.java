package day0714;

import java.util.Arrays;

public class PG_정렬_K번째수 {
    public static void main(String[] args) {
        int[] ar = {1, 5, 2, 6, 3, 7, 4};
        int[][] com = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(ar, com);
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int N = commands[i][1] - commands[i][0] + 1;
            int[] arr = new int[N];

            int id = 0;
            for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
                arr[id] = array[j];
                id++;
            }

            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();

            Arrays.sort(arr);
            int num = arr[commands[i][2]-1];
            answer[i] = num;
//            System.out.println(num);
        }
        return answer;
    }
}
