package day0721;

import java.lang.reflect.Array;
import java.util.*;

public class PG_두개뽑아서더하기 {
    public static void main(String[] args) {
        int[] n = {2,1,3,4,1};
        solution(n);
    }
    static int[] choice;
    static Set<Integer> set;
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        choice = new int[2];
        set = new HashSet<>();
        comb(0,0,numbers);

        answer = new int[set.size()];
        int idx = 0;
        for (int x:set) {
            answer[idx] = x;
            idx++;
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void comb(int cnt, int cur, int[] num){
        if(cnt == 2){
            set.add(choice[0] + choice[1]);
            return;
        }
        for (int i = cur; i < num.length; i++) {
            choice[cnt] = num[i];
            comb(cnt+1, i+1, num);
        }
    }
}
