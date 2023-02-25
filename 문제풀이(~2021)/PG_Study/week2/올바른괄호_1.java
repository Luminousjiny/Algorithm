package study_week2;

public class 올바른괄호_1 {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') count++;
            else count--;
            if(count < 0) {
                answer = false;
                break;
            }
        }
        if(answer && count != 0) answer = false;
        return answer;
    }
}
