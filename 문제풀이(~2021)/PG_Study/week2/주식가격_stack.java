package PG_codingTestStudy;

import java.util.Stack;
// 2중 for문으로 풀이를 했지만
// stack으로 재 풀이를 했다.
public class 주식가격_stack {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++){
            // stack에 저장된 인덱스의 prices[] 값이 현재 prices[i] 값보다 작으면
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i-idx; // 얼마만에 찾았는지
            }
            stack.push(i);
        }
        // 끝까지 가격이 떨어지지 않은 값 처리
        while(!stack.isEmpty()){
            int id = stack.pop();
            answer[id] = prices.length - id -1;
        }
        return answer;
    }
}
