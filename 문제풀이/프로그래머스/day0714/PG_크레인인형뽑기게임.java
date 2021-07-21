package day0714;

import java.util.Stack;

// 2019 카카오 개발자 겨울 인턴십
public class PG_크레인인형뽑기게임 {
    public static void main(String[] args) {

    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> box = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int nowY = moves[i]-1;
            if(board[N-1][nowY] == 0){
                continue;
            }else{
                for (int j = 0; j < N; j++) {
                    if(board[j][nowY] == 0) continue;
                    else{
                        if(box.isEmpty()){
                            box.add(board[j][nowY]);
                        }else{
                            if(box.peek() == board[j][nowY]){
                                answer++;
                                box.pop();
                            }else{
                                box.add(board[j][nowY]);
                            }
                        }

                        board[j][nowY] = 0;
                        break;
                    }
                }
            }
        }
        return answer*2;
    }
}
