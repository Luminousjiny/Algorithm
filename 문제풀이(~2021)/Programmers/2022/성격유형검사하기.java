package day0822;

public class 성격유형검사하기 {
    public static void main(String[] args) {
        //String survey[] = {"AN", "CF", "MJ", "RT", "NA"};
        //int choices[] = {5, 3, 2, 7, 5};

        String survey[] = {"TR", "RT", "TR"};
        int choices[] = {7, 1, 3};

        String res = solution(survey, choices);
        System.out.println(res);

    }
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        char map[][] = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int sum[][] = new int[4][2];

        for(int i=0; i<survey.length; i++){
            char alpa1 = survey[i].charAt(0);
            char alpa2 = survey[i].charAt(1);
            int num = choices[i];

            // 1. 행 찾기
            int row = 0;
            for(int j=0; j<4; j++){
                for(int k=0; k<2; k++){
                    if(map[j][k] == alpa1 || map[j][k] == alpa2){
                        row = j;
                        break;
                    }
                }
            }

            // 2. 값 파악
            int plusCnt = Math.abs(4-num);
            if(num < 4){
                if(map[row][0] == alpa1){
                    sum[row][0] += plusCnt;
                }else{
                    sum[row][1] += plusCnt;
                }
            } else{
                if(map[row][0] == alpa2){
                    sum[row][0] += plusCnt;
                }else{
                    sum[row][1] += plusCnt;
                }
            }
        }

        // 3. 최종 알파벳 추출
        for(int i=0; i<4; i++){
            if(sum[i][0] < sum[i][1]){
                answer += map[i][1];
            } else {
                answer += map[i][0];
            }
        }

        return answer;
    }
}
