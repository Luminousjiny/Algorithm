package test;

import java.util.Scanner;

public class BOJ_11726_2xn타일링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if(i <= 2) dp[i] = i;
            else dp[i] = (dp[i-2] + dp[i-1])%10007;
        }
        System.out.println(dp[n]);
    }
}
