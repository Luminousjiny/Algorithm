# 🔰 우선순위큐(Priority Queue)   
  
```text   
✔ 큐
> 일반적인 큐는 데이터를 일시적으로 쌓아두기 위한 자료구조
> FIFO(First In First Out)의 구조... 먼저 들어온 데이터가 먼저 나가는 구조  
```   
## ◽ 우선순위 큐란?   
> 우선순위를 먼저 결정을 하고, 우선순위가 높은 데이터가 먼저 나가는 구조의 자료구조  
> 일반적으로 힙을 이용하여 구현    
> 데이터를 삽입할 때 우선순위를 기준으로 최대힙 혹은 최소 힙을 구성하고 
> 데이터를 꺼낼 때 루트 노드를 얻어낸 뒤 
> 루트 노드를 삭제할 때는 빈 루트 노드 위치에 맨 마지막 노드를 삽입한 후 
> 아래로 내려가면서 적절한 자리를 찾아서 옮기는 방식으로 진행   

---    
## ◽ 우선순위 큐 특징   
> 1. 우선순위가 높은 데이터를 먼저 꺼내서 처리하는 구조    
>   -> 큐에 들어가는 원소는 비교가 가능한 기준이 있어야 함.   
> 2. 내부 요소는 힙으로 구성되어 이진트리 구조를 이룸   
> 3. 시간복잡도 : O(NLogN)   
> 4. 우선순위를 중요시 해야하는 상황에 쓰임.   

---   
## ◾ 우선순위큐 사용법   
### ✔ 선언 
> 1. java.util.PriorityQueue 를 import할 것   
> 2. Queue<Element> queue = new Queue<>()와 같은 형식으로 선언   
> 3. 기본적으로 우선순위가 낮은 숫자부터 부여된다.
>     -> 반대로 하고싶을 경우, Collections.reverseOrder() 메서드를 활용

```java   
import java.util.PriorityQueue; //import

//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

//String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(); 

//String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```    
---   
### ✔ 값 추가   
> 1. add(value) 또는 offer(value)사용   
> 2. 삽입에 성공하면true를 반환   
> 3. 실패하게 되면,  IllegalStateException을 발생   

```java   
pq.add(1); // 1 추가  
pq.offer(2); // 2 추가  
```   
---   
### ✔ 값 삭제   
> 1. poll() 또는 remove() 사용   
> 2. 우선순위가 가장 높은 값이 제거   
> 3. poll()은 우선순위큐가 비어있으면 null 반환   
> 4. clear()은 우선순위큐 초기화   

```java   
pq.poll(); // 첫번째 값 삭제, 비어있으면 null 
pq.remove(); // 첫번째 값 삭제
pq.clear(); // 큐 초기화   
```   
---   
### ✔ 값 출력   
> peek() 이용 -> 우선순위 가장 높은 데이터 출력(삭제X)   
```java   
pq.peek(); // 첫번째 값 출력
```   
---   
[참고자료] : https://coding-factory.tistory.com/603?category=758267   
