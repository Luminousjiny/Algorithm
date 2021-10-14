package study_week4;

// n=1 -> 1
// n=2 -> 2
// n=3 -> 1+2 = 3
// n=4 -> 2+3 = 5
// 6=5 -> 3+5 = 8
// ... 즉, 피보나치 수열 형식으로 증가함
// 그러나 재귀를 이용해서 피보나치를 구현하면 시간초과 발생 => DP 사용

public class 타일링2Xn_1 {
    public int solution(int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if(i <= 2) dp[i] = i;
            else dp[i] = (dp[i-2] + dp[i-1])%1000000007;
        }
        return dp[n];
    }
}
