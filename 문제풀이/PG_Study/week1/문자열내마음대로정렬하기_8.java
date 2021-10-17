package PG_codingTestStudy;

import java.util.Arrays;

public class 문자열내마음대로정렬하기_8 {
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        String[] answer = new String[len];
        Alpha[] alphas = new Alpha[len];
        for (int i = 0; i < len; i++) {
            alphas[i] = new Alpha(i, strings[i].charAt(n), strings[i]);
        }
        Arrays.sort(alphas);
        for (int i = 0; i < len; i++) {
            answer[i] = strings[alphas[i].id];
        }
        return answer;
    }
    static class Alpha implements Comparable<Alpha> {
        int id;
        char c;
        String s;
        Alpha(int id, char c, String s){
            this.id = id;
            this.c = c;
            this.s = s;
        }

        @Override
        public int compareTo(Alpha o) {
            if(this.c == o.c) return this.s.compareTo(o.s);
            return Integer.compare(this.c, o.c);
        }
    }
}
