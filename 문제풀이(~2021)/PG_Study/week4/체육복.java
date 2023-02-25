package PG_codingTestStudy;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+2];
        for(int i=0; i<lost.length; i++){
            students[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++){
            students[reserve[i]]++;
        }
        for(int i=0; i<students.length; i++){
            if(students[i] != -1) continue;
            if(students[i-1] == 1){
                students[i]++;
                students[i-1]--;
            }else if(students[i+1] == 1){
                students[i]++;
                students[i+1]--;
            }
        }
        for(int i=1; i<students.length-1; i++){
            if(students[i] != -1) answer++;
        }
        return answer;
    }
}
