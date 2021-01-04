# 🔹 LCS(Longest Common Subsequence) 알고리즘
> 말 그대로 가장 긴(longest) 공통된(Common) 부분수열(subsequance)     
> 즉, 임의의 두 수열에서 각각의 부분 수열들 중, 서로 같은 부분 수열 중에서 가장 긴 부분 수열을 의미   

---   
## 💻 대표 문제 > BOJ_9251   
- https://www.acmicpc.net/problem/9251     

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length()+1][s2.length()+1];// 첫번째 문자열 길이 X 두번째 문자열 길이 -> 1인덱스부터 사용...
        // dp 탐색
        for (int i = 1; i <= s1.length(); i++) { // 1번째 문자열 길이를 기준으로
            for (int j = 1; j <= s2.length(); j++) { // 2번째 문자열과 비교
                if( s1.charAt(i-1)!= s2.charAt(j-1) ) dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]); // 다를 경우(매칭 X) 둘 중 큰수
                else dp[i][j] = dp[i-1][j-1] + 1; // 같을 경우(매칭 O) +1 증가
            }
        }
        System.out.println(dp[s1.length()][s2.length()]); // 마지막 값이 최장 길이
    }
} 
// s1.length(), s2.length() ... int 형 변수에 담아서 사용하면 런타임 에러남.... 
```     
> 1. 파악하기 편하기 위해 N+1로 하고 0인덱스는 0으로 채우기   
> 2. 가로 세로 문자가 매치가 되면 왼쪽 위 숫자+1         
>          _개수 하나 증가 의미_    
> 3. 매치가 안되면 왼쪽과 위쪽 중 큰 수            
>          _더이상 증가 없이 그대로 간다는 의미_      
> 4. 가장 마지막에 나온 숫자가 최장 길이   

![image](https://user-images.githubusercontent.com/72757829/104224700-b1c9a600-5488-11eb-86f6-b4ebf5fd5969.png)   
  
----    
[참고사이트] https://fbtmdwhd33.tistory.com/58      
[참고 영상] https://www.youtube.com/watch?v=P-mMvhfJhu8&feature=youtu.be   

