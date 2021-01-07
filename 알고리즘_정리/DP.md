# 🧾 DP(Dynamic Programming)   
### 다이나믹 프로그래밍 = 동적 계획법   
> 하나의 문제는 단 한번만 풀도록 하는 알고리즘   
> 한번 푼 것을 여러번 다시 푸는 비효율적 알고리즘을 개선시키는 방법임 

#### ◽ 필요한 가정   
- 큰 문제를 작은 문제로 나눌 수 있다.
- 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.   

### ✔ 메모이제이션   
- 메모이제이션이 사용된다는 점이 분할정복과의 차이점    
- 이미 계산한 결과를 배열에 저장하여 나중에 동일한 계산을 할 때, 저장된 값을 반환하면 된다.     

#### 예시> 피보나치 수열   
![fibo](https://user-images.githubusercontent.com/72757829/103916275-92144400-514f-11eb-80fe-4fdc109b0e8b.PNG)   
> 메모이제이션 방식이 재귀함수 방식보다 시간복잡도 빨라짐 O(N)    

- 재귀함수 방식   
```java   
public int fibonacci(int n){
    if(n<=1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
}
```   
- 메모이제이션 방식   
```java   
   static int[] memo = new int[50];
    static int fibo(int n){
        if(n <= 1) return n;
        else if(memo[n] != 0) return memo[n];
        else return memo[n] = fibo(n-1) + fibo(n-2);
```   
_더 공부해서 정리하자 dp...._
---   
[참고사이트] : https://do-rang.tistory.com/9   
