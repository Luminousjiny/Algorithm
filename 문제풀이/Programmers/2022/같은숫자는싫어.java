package day0825;

import java.util.Stack;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }

        int len = stack.size();
        int[] answer = new int[len];
        for(int i=len-1; i>=0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
}
