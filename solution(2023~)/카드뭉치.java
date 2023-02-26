package Lv1.day0226;

import java.util.Stack;

public class 카드뭉치 {
    public static void main(String[] args) {
        // String[] c1 = {"i", "drink", "water"};
        String[] c1 = {"i", "water", "drink"};
        String[] c2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String ans = solution(c1, c2, goal);
        System.out.println(ans);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        for (int i = cards1.length-1; i >= 0; i--) {
            stack1.push(cards1[i]);
        }
        for (int i = cards2.length-1; i >= 0; i--) {
            stack2.push(cards2[i]);
        }

        for (String s : goal) {
            if( (!stack1.isEmpty() && !s.equals(stack1.peek())) &&
                    ((!stack2.isEmpty() && !s.equals(stack2.peek())) || stack2.isEmpty())){
                answer = "No";
                break;
            } else if ( stack1.isEmpty() && (!stack2.isEmpty() && !s.equals(stack2.peek()))){
                answer = "No";
                break;
            }

            if(!stack1.isEmpty() && s.equals(stack1.peek())){
                stack1.pop();
            } else if(!stack2.isEmpty() && s.equals(stack2.peek())){
                stack2.pop();
            }
        }

        return answer;
    }
}
