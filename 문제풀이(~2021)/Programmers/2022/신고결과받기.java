package day0824;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int[] ans = solution(id, report, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // report 중복 제거 : 같은 사람이 같은 사람 신고건은 하나로
        HashSet<String> deReport = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            deReport.add(report[i]);
        }
        int reportCnt = deReport.size();
        int memberCnt = id_list.length;

        // hash로 제거한 report 다시 넣기
        int n = 0;
        for (String s:deReport) {
            report[n] = s;
            n++;
        }

        int[] answer = new int[memberCnt]; // 메일 횟수 (return)
        int[] id_report_cnt = new int[memberCnt]; // 신고 횟수 체크
        ArrayList<String> more_report_k = new ArrayList<>(); // k번 넘은 사람 add

        String[][] copyReport = new String[reportCnt][2];
        for (int i = 0; i < reportCnt; i++) { // 0 index : 신고자 -> 1 index : 당한자
            String[] rpt = report[i].split(" ");
            copyReport[i][0] = rpt[0];
            copyReport[i][1] = rpt[1];
        }

        // 신고당한 횟수 체크
        for (int i = 0; i < reportCnt; i++) {
            int idx = findIdIndex(copyReport[i][1], id_list);
            id_report_cnt[idx]++;
        }

        // k번 이상 신고당한 사람 추출
        for (int i = 0; i < memberCnt; i++) {
            if(id_report_cnt[i] >= k){
                more_report_k.add(id_list[i]);
            }
        }

        // 메일 보낼 횟수 id 별로 체크
        for (int i = 0; i < reportCnt; i++) {
            for (int j = 0; j < more_report_k.size(); j++) {
                if(copyReport[i][1].equals(more_report_k.get(j))){
                    int idx = findIdIndex(copyReport[i][0], id_list);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }

    private static int findIdIndex(String parm, String[] id_list){
        int idx = 0;
        for (int i = 0; i < id_list.length; i++) {
            if(id_list[i].equals(parm)){
                idx = i;
                break;
            }
        }
        return idx;
    }
}
