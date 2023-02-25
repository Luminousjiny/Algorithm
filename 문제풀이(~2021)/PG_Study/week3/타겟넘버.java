package PG_codingTestStudy;
// 조합을 해서 선택된 숫자는 더하고
// 선택되지 않은 숫자는 빼서
// 둘을 합한 숫자가 target이 되는지 확인
public class 타겟넘버 {
    int[] visit;
    int answer;
    public int solution(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++){
            visit = new int[i];
            comb(0, 0, i, numbers, target);
        }
        return answer;
    }
    void comb(int cnt, int cur, int k, int[] num, int target){
        if(cnt == k){
            boolean[] check = new boolean[num.length];
            int num1 = 0;
            int num2 = 0;
            for(int a=0; a<visit.length; a++){
                check[visit[a]] = true;
                num1 += num[visit[a]];
            }
            for(int b=0; b<check.length; b++){
                if(!check[b]) num2 -= num[b];
            }
            if(num1+num2 == target) answer++;
            return;
        }
        for(int i=cur; i<num.length; i++){
            visit[cnt] =i;
            comb(cnt+1, i+1, k, num, target);
        }
    }
}
