package test;

public class PG_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total = 0;
        for(int i=1; i<=count; i++){
            total += (long) price *i;
        }
        answer = total-money;
        if(answer<=0) answer = 0;
        return answer;
    }
}
