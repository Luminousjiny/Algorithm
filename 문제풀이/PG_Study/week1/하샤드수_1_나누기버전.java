package study_week1;

public class 하샤드수_1_나누기버전 {
    public boolean solution(int x) {
        if(x<=10) return true;
        int num = x;
        int sum = 0;
        while (num > 0){
            sum += num%10;
            num /= 10;
        }
        return x%sum == 0;
    }
}
