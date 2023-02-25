package day0721;

public class PG_로또의최고순위와최저순위 {
    public static void main(String[] args) {

    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int right = 0;
        int zero = 0;
        for (int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    right++;
                    break;
                }
            }
        }

        int low_lank = 0;
        if(right==0) low_lank = 6;
        else low_lank = 6-right+1;
        answer[1] = low_lank;

        int high_lank = low_lank-zero;
        if(high_lank<1) high_lank = 1;
        answer[0] = high_lank;

        return answer;
    }
}
