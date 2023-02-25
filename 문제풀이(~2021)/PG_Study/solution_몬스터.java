package PG_codingTestStudy;

public class solution_몬스터 {
    public int solution(int[] monster, int S1, int S2, int S3) {
        int answer = 0;
        int cnt = 0;
        for(int i=1; i<=S1; i++){
            for(int j=1; j<=S2; j++){
                for(int k=1; k<=S3; k++){
                    int num = 1+i+j+k;
                    boolean check = true;
                    for(int a=0; a<monster.length; a++){
                        if(num == monster[a]){
                            check = false;
                            break;
                        }
                    }
                    if(check) cnt++;
                }
            }
        }
        double ans = (double)cnt/(S1*S2*S3)*1000;
        answer = (int)ans;
        return answer;
    }
}
