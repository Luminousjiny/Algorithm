package day0721;

import java.util.ArrayList;

public class PG_모의고사 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] ansCnt = new int[3];
        int cnt = 0;
        int id = 0;
        for (int j = 0; j < answers.length; j++) {
            if(id == p1.length) id = 0;
            if(answers[j] == p1[id]) cnt++;
            id++;
        }
        ansCnt[0] = cnt;
        cnt = 0;
        id = 0;
        for (int j = 0; j < answers.length; j++) {
            if(id == p2.length) id = 0;
            if(answers[j] == p2[id]) cnt++;
            id++;
        }
        ansCnt[1] = cnt;
        cnt = 0;
        id = 0;
        for (int j = 0; j < answers.length; j++) {
            if(id == p3.length) id = 0;
            if(answers[j] == p3[id]) cnt++;
            id++;
        }
        ansCnt[2] = cnt;

        int MAX = 0;
        for (int i = 0; i < 3; i++) {
            MAX = Math.max(MAX, ansCnt[i]);
        }
        for (int i = 0; i < 3; i++) {
            if(MAX==ansCnt[i]) arr.add(i+1);
        }
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
