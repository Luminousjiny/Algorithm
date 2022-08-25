package day0825;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,6,7,8,0};
        int res = solution(num);
        System.out.println(res);
    }
    public static int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int num = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != num){
                while(true){
                    if(numbers[i] == num) {
                        i--;
                        break;
                    }
                    answer += num;
                    num++;
                }
            }else{
                num++;
            }
        }

        if (num < 10){
            for(int i=num; i<10; i++){
                answer += i;
            }
        }

        return answer;
    }
}
