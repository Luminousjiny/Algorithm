# 🔹 우선순위 큐를 위해 만들어진 Heap 자료구조    
---
## ✔ Heap 특징
> 1. 완전 이진트리 기반 구현
> 2. 느슨한 정렬(반정렬) 유지
> 3. 중복 값 허용
> 4. 배열로 가장 효과적인 구현 가능
---
## ✔ Heap 종류
### 1. 최대 힙
#### 루드 토드에 최대값이 있는 형태의 힙을 뜻한다.
```java
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                int size = pq.size();
                if(size == 0) {
                    sb.append(0).append("\n");
                } else if( size == 1){
                    sb.append(pq.poll()).append("\n");
                } else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
```   

### 2. 최소 힙
#### 루드 토드에 최솟값이 있는 형태의 힙을 뜻한다.
```java
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                int size = pq.size();
                if(size == 0) {
                    sb.append(0).append("\n");
                } else if( size == 1){
                    sb.append(pq.poll()).append("\n");
                } else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
    ```   
![qu](https://user-images.githubusercontent.com/72757829/102923936-f8546200-44d3-11eb-87f9-50c241050f30.PNG)     
### 3. 절대 힙 -> 최대힙, 최소힙 특징 이용   
```java
 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ppq = new PriorityQueue<>(); // 양수 1, 2, 3 ....
        PriorityQueue<Integer> mpq = new PriorityQueue<>(Collections.reverseOrder()); // 음수 -1, -2, -3 ...
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(ppq.isEmpty() && mpq.isEmpty()){
                    sb.append(0).append("\n");
                }else if(ppq.isEmpty()){
                    sb.append(mpq.poll()).append("\n");
                }else if(mpq.isEmpty()){
                    sb.append(ppq.poll()).append("\n");
                }else {
                    int ppeek = Math.abs(ppq.peek());
                    int mpeek = Math.abs(mpq.peek());
                    if(ppeek > mpeek){
                        sb.append(mpq.poll()).append("\n");
                    }else if( ppeek < mpeek){
                        sb.append(ppq.poll()).append("\n");
                    }else{
                        sb.append(mpq.poll()).append("\n");
                    }
                }
            }else{
                if(x>0) ppq.add(x);
                else mpq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
```
---
## ✔ Heap 표현
#### - 이진탐색 트리로 빈 노드가 없다.
#### - 이 번호를 배열의 인덱스로 생각하면, 배열에 힙의 노드를 쉽게 저장 및 탐색 가능하다.
#### - 1번 인덱스부터 사용한다.
![zz](https://user-images.githubusercontent.com/72757829/102924428-e58e5d00-44d4-11eb-8f76-95723347cb28.PNG)
---   
## ✔ 인덱스 구하기    
#### 힙에는 인덱스 번호라는 특징이 존재하기 때문에 다음과 같은 방식으로 인덱스 위치를 구할 수 있다.   
#### - 왼쪽 자식의 인덱스 : (부모의 인덱스) * 2    
#### - 오른쪽 자식의 인덱스 : (부모의 인덱스) * 2 + 1    
