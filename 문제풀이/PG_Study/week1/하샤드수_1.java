package study_week1;

public class 하샤드수_1 {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String s = Integer.toString(x);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = Integer.parseInt(String.valueOf(c));
            sum += num;
        }
        if(x%sum == 0) answer = true;
        else answer = false;
        return answer;
    }
}
