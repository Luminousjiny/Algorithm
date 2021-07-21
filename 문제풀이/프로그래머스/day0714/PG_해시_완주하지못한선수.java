package day0714;

public class PG_해시_완주하지못한선수 {
    public static void main(String[] args) {
        String[] all = {"mislav", "stanko", "mislav", "ana"};
        String[] finish ={"stanko", "ana", "mislav"};
        String ans =  solution(all, finish);
        System.out.println(ans);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean[] finish = new boolean[participant.length];
        for (int i = 0; i < completion.length; i++) {
            for (int j = 0; j < participant.length; j++) {
                if(completion[i].equals(participant[j])) {
                    finish[j] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < finish.length; i++) {
            if(!finish[i]){
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
