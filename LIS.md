# ▶ 최장 증가 수열(LIS, Longest Increasing Subsequence)

### 1. dp를 이용 -> 마지막 수가 x번째인 가장 긴 최장증가수열
#### 시간복잡도 : O(N^2)   
```java
import java.util.*;

public class LIS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] dp = new int[n];
			int max = 0;
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			dp[0] = 1;
			
			for(int i = 1; i < n; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(a[i] >= a[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
				}
				max = Math.max(max,dp[i]);
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
```   
---   
### 2. dp배열이용 ... -> 길이가 x인 최장증가수열의 마지막 수의 최소값   
#### 시간복잡도 : O(NlogN)      
#### 반드시 DP 배열이 가장 긴 증가하는 부분 순열의 순서에 맞지 않음   
##### .... 이분탐색으로원소를 바꾸므로 차이가 생길 수 있음   
#### 전체길이를 알 수 있음!!! -> "전체길이 구하는 문제"에 사용할 알고리즘   
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12015 {
    static StringTokenizer st;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 A의 길이
        st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(arr.isEmpty()) arr.add(num); // 리스트가 비어있으면 넣어줌
            else { // 데이터가 있을 경우
                if(arr.get(arr.size()-1) >= num){ // 가장 마지막 원소가 입역 값보다 크면
                    // 입력값 보다는 큰, 가장 작은 값 찾고 그 자리에 넣기 -> 이분탐색
                    binary(0, arr.size()-1, num); // 시작, 끝 인덱스, 입력 값으로 이분탐색 시작
                }else arr.add(num); // 입력값이 더 크다면 그냥 뒤에 추가
            }
        }
        System.out.println(arr.size());
    }

    static void binary(int start, int end, int num) {
        while (start < end){
            int mid = (start + end)/2;
            if(arr.get(mid) >= num) end = mid;
            else start = mid+1;
        }
        arr.set(end, num);
    }
}

```   
---   
### 참고 사이트   
> 1. https://dheldh77.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%B5%9C%EC%9E%A5-%EC%A6%9D%EA%B0%80-%EC%88%98%EC%97%B4LIS-Longest-Increasing-Subsequence   
> 2. https://codedoc.tistory.com/414    
