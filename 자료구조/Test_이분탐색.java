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
