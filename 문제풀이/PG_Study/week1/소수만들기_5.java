package PG_codingTestStudy;

public class 소수만들기_5 {
    static int ans;
    public int solution(int[] nums) {
        number = new int[3];
        comb(0, 0, nums);
        return ans;
    }

    static int[] number;
    static void comb(int cnt, int cur, int[] input){
        if(cnt == 3){
            int sum = 0;
            for(int i=0; i<number.length; i++){
                sum += number[i];
            }
            boolean check = true;
            for(int i=2; i<sum; i++){
                if(sum%i == 0){
                    check = false;
                    break;
                }
            }
            if(check) ans++;
            return;
        }
        for(int i=cur; i<input.length; i++){
            number[cnt] = input[i];
            comb(cnt+1, i+1, input);
        }
    }
}
