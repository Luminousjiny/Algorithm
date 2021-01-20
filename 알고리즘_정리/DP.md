# 🧾 DP(Dynamic Programming)   
### 다이나믹 프로그래밍 = 동적 계획법   
> 하나의 문제는 단 한번만 풀도록 하는 알고리즘     
> 한번 푼 것을 여러번 다시 푸는 비효율적 알고리즘을 개선시키는 방법임     

#### ◽ 필요한 가정   
- 큰 문제를 작은 문제로 나눌 수 있다.
- 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.   

### 📌 메모이제이션   
- 다이나믹 프로그래밍을 구현하는 방법 중 하나   
- 메모이제이션이 사용된다는 점이 분할정복과의 차이점    
- 이미 계산한 결과를 배열에 저장하여 나중에 동일한 계산을 할 때, 저장된 값을 반환하면 된다.     
- 값을 기록해 놓는다는 점에서 __캐싱(Caching)__ 이라고도 한다.   

#### ✔ 메모이제이션 활용 순서     
> 1. 중복호출이 일어나는지 확인    
> 2. 메모할 자료구조 결정 → 1차원배열, 2차원배열, collection    
> 3. 메모상태구분 → 초기값 설정 : 메모되지 않은 상태    
> 4. 메모가 안된 경우에 실행 시, 결과 메모    
> 5. 메모된 값 return    

### 📌 탑다운 VS 보텀업   
> ◽ 탑다운(메모이제이션) 방식 = 하향식   
> ◽ __보텀업__ = 상향식 -> DP 전형적인 형태    
>       ▪ 장점 -> 재귀 호출이 없으므로 __시간과 메모리 사용량을 줄일 수__ 있다.
> 결과 저장용 리스트는 __DB테이블__ 이라고 부름    

---   
#### 예시> 피보나치 수열   
![fibo](https://user-images.githubusercontent.com/72757829/103916275-92144400-514f-11eb-80fe-4fdc109b0e8b.PNG)   
> 메모이제이션 방식이 재귀함수 방식보다 시간복잡도 빨라짐 __O(N)__       

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
    }
```   

### 📌 DP VS 분할정복   
- 두 알고리즘 모두 __최적 부분 구조__ 를 가질 때 사용 
    _큰 문제를 작은 문제로 나누고, 작은 문제의 답을 모아서 큰 문제 해결_   
- 두 알고리즘의 가장 큰 차이점은 __부분문제의 중복__     
    - DP문제에서는 각 부분 문제들이 서로 영향을 미치며 부분문제가 중복됨   
    - 분할정복 문제에서는 동일 부분 문제가 반복적으로 계산되지 않음    
    
---   
#### ✔ 거스름돈에서 동전 최소 개수
```java   
// 동전단위 1, 4, 6 : 배수의 성질이 아님
// 동전개수에는 제한이 없음
public class MinCoinChangeTest {
    static  int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int[] D = new int[money+1]; // 각 금액의 최적 교환 동전 개수를 저장하는 동적테이블

        // 각 금액의 최적 교환 동전개수 구함
        // 1원시도 최적 개수 : D[i-1]+1
        // 4원시도 최적 개수 : D[i-4]+1
        // 6원시도 최적 개수 : D[i-6]+1
        // 위 3가지 경우 중 가장 최적의 값을 저장

        for (int i = 1; i <= money ; i++) {
            min = Integer.MAX_VALUE; // 최소값으로 갱신할 변수
            //3가지의 if문 모두 수행해보고 가장 최소값이 저장 -> else if가 아님!
            if (i>=1 && D[i-1]+1<min) min = D[i-1]+1;
            if (i>=4 && D[i-4]+1<min) min = D[i-4]+1;
            if (i>=6 && D[i-6]+1<min) min = D[i-6]+1;

            D[i] = min;
        }
        System.out.println(D[money]);

    }
}
```   

---   
[참고사이트] : https://do-rang.tistory.com/9   
