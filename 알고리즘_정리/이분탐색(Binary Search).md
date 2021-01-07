# 🔹 이분탐색 
### = 이진탐색 (Binary Search)   
## ◽ 시간복잡도   
> 'T = K * logN'으로 O(logN)   
---
## ◽ 제약사항
> 1. 유한한 범위 데이터
> 2. 정렬이 되어있어야 함
---    
## ◽ java code
> [사용할 변수 ]
> start : 탐색 범위의 첫 인덱스
> end : 탐색 범위의 마지막 인덱스
> mid : 탐색 범위의 중앙값의 인덱스, (low + high)/2
```java
package day0101;

public class Test_이분탐색 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        Tree t = new Tree();
        t.makeTree(a);
        t.searchBTress(t.root, 2); // 2번 데이터 찾기
    }
}

class Tree{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    Node root; // 트리 시작
    public void makeTree(int[] a){
        root = makeTreeR(a, 0, a.length-1);
    }
    // 트리만들기
    public Node makeTreeR(int[] a, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) /2;
        Node node = new Node(a[mid]);
        node.left = makeTreeR(a, start, mid-1);
        node.right = makeTreeR(a, mid+1, end);
        return node;
    }
    // 잘 찾았는지 확인하는 이진검색
    public void searchBTress (Node n, int find){
        if(find < n.data){
            System.out.println("찾는 값이 데이터보다 작음");
            searchBTress(n.left, find);
        }else if( find > n.data){
            System.out.println("찾는 값이 데이터보다 큼");
            searchBTress(n.right, find);
        }else{
            System.out.println("값을 찾음!");
        }
    }
}

```    
![이진탐색트리](https://user-images.githubusercontent.com/72757829/103440650-b624e080-4c8a-11eb-9777-6df7c131cd23.PNG)    
