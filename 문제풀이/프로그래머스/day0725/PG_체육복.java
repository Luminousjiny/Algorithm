package day0725;

import java.util.ArrayList;
import java.util.Arrays;

public class PG_체육복 {
    public static void main(String[] args) {
        int[] nn = {2,3,4};
        int[] mm = {3,4,5};
        int ans = solution(5, nn,mm);
        System.out.println(ans);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n- lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] plus = new boolean[n];
        for (int i = 0; i < reserve.length; i++) {
            plus[reserve[i]-1] = true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < lost.length; i++) {
            if(plus[lost[i]-1]){
                plus[lost[i]-1] = false;
                answer++;
            }
            else{
                arr.add(lost[i]);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            int idx = arr.get(i)-1;
            if(idx > 0 && plus[idx-1]){
                plus[idx-1] = false;
                answer++;
            }else if(idx < n-1 && plus[idx+1]){
                plus[idx+1] = false;
                answer++;
            }
        }
        return answer;
    }
}
