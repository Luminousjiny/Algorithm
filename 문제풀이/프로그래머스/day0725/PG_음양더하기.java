package day0725;

public class PG_음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int num = absolutes[i];
            if(signs[i]){
                answer+=num;
            }else{
                answer-=num;
            }
        }
        return answer;
    }
}
