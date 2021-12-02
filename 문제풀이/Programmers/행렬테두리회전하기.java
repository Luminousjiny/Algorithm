// 2021 데브매칭
public class 행렬테두리회전하기 {
    int[] di = {1,0,-1,0};
    int[] dj = {0,1,0,-1};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // map 채우기
        int num = 1;
        int[][] map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = num;
                num++;
            }
        }
        for(int i=0; i<queries.length; i++){
            // 0, 2 인덱스 행의 범위
            // 1, 3 인덱스 열의 범위
            int tmp = map[queries[i][0]][queries[i][1]];
            int min = tmp;

            // 첫 열 데이터 -> 행 -1
            for(int j=queries[i][0]+1; j<=queries[i][2]; j++){
                int moveNum = map[j][queries[i][1]];
                map[j-1][queries[i][1]] = moveNum;
                min = Math.min(min, moveNum);
            }

            // 마지막 행 데이터 -> 열 -1
            for(int j=queries[i][1]+1; j<=queries[i][3]; j++){
                int moveNum = map[queries[i][2]][j];
                map[queries[i][2]][j-1] = moveNum;
                min = Math.min(min, moveNum);
            }

            // 마지막 열 데이터 -> 행 +1
            for(int j=queries[i][2]-1; j>=queries[i][0]; j--){
                int moveNum = map[j][queries[i][3]];
                map[j+1][queries[i][3]] = moveNum;
                min = Math.min(min, moveNum);
            }

            // 첫 행 데이터 -> 열 +1
            for(int j=queries[i][3]-1; j>=queries[i][1]; j--){
                int moveNum = map[queries[i][0]][j];
                map[queries[i][0]][j+1] = moveNum;
                min = Math.min(min, moveNum);
            }

            map[queries[i][0]][queries[i][1]+1] = tmp;
            answer[i] = min;
        }
        return answer;
    }
}
