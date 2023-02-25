package PG_codingTestStudy;
// 풀이1. DFS
public class 단어변환 {
    boolean[] select;
    int min;
    public int solution(String begin, String target, String[] words) {
        select = new boolean[words.length];
        min = Integer.MAX_VALUE;
        DFS(0, begin, target, words);
        if(min == Integer.MAX_VALUE) min = 0;
        return min;
    }

    void DFS(int cnt, String begin, String target, String[] words){
        if(begin.equals(target)){
            min = Math.min(min,cnt);
            return;
        }
        for(int i=0; i<words.length; i++){
            if(select[i]) continue;
            int count = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)) count++;
            }
            if(count == 1){
                select[i] = true;
                DFS(cnt+1, words[i], target, words);
                select[i] = false;
            }
        }
    }
}
