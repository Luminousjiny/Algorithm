package programmers;
// 피보나치 수의 마지막 0의 개수
public class 피보나치끝자락 {
    public static void main(String[] args) {
        int ans = solution(25);
        System.out.println(ans);
    }
    public static int solution(int n) {
        int answer = 0;
        int i = 1;
        int a = 5;
        while(n / a > 0) {
            answer += n / a;
            i++;
            a = (int)Math.pow(5, i);
        }
        return answer;
    }
}
