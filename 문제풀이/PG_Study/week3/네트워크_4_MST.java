package study_week3;

import java.util.HashSet;
import java.util.Set;

public class 네트워크_4_MST {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(computers[i][j] == 1) union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == i) set.add(parent[i]);
        }
        return set.size();
    }

    static int find(int x){
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x<y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
