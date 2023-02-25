// 2017 KAKAO 본선
public class 단체사진찍기 {
    char[] permList;
    boolean[] visit;
    int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        char[] kind = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permList = new char[8];
        visit = new boolean[8];
        perm(0, data, kind);
        return answer;
    }

    void perm(int cnt, String[] data, char[] kind){
        if(cnt == 8){
            if(check(data)) answer++;
            return;
        }
        for(int i=0;i<kind.length; i++){
            if(visit[i]) continue;
            permList[cnt] = kind[i];
            visit[i] = true;
            perm(cnt+1, data, kind);
            visit[i] = false;
        }
    }

    boolean check(String[] data){ // 조건이 맞으면 true, 아니면 false
        for(int i=0; i<data.length; i++){
            char person1 = data[i].charAt(0);
            char person2 = data[i].charAt(2);
            char range = data[i].charAt(3); // =, <, >
            int count = Integer.parseInt(Character.toString(data[i].charAt(4)));

            int idx1 = 0;
            int idx2 = 0;
            for(int j=0; j<permList.length; j++){
                if(permList[j] == person1) {
                    idx1 = j;
                }
                if(permList[j] == person2){
                    idx2 = j;
                }
                if(idx1 != 0 && idx2 != 0) break;
            }

            if(range == '='){ // = count
                if(Math.abs(idx1-idx2)-1 != count) return false;
            }else if(range == '>'){ // > count
                if(Math.abs(idx1-idx2)-1 <= count) return false;
            }else { // < count
                if(Math.abs(idx1-idx2)-1 >= count) return false;
            }
        }
        return true;
    }
}
