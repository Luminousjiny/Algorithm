package study_week1;

public class 다음큰숫자_6 {
    public int solution(int n) {
        int answer = 0;
        int nCnt = count(n);
        while (true){
            n++;
            int nextCnt = count(n);
            if(nCnt == nextCnt){
                answer = n;
                break;
            }
        }
        return answer;
    }

    public static int count(int number){ // 2진수 변환 후, 1의 개수 파악
        int cnt = 0;
        while (true){
            if(number/2 == 0){
                if(number%2 == 1) cnt++;
                break;
            }else if(number/2 == 1){
                cnt++;
                if(number%2 == 1) cnt++;
                break;
            }else{ // 나머지 붙이고 숫자를 몫으로 세팅해해
                if(number%2 == 1) cnt++;
                number = number/2;
            }
        }
        return cnt;
    }
}
