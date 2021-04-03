package programmers.카카오커머스;

public class Solution1 {
    public static void main(String[] args) {
        int[] gift = {4,5,3,2,1};
        int[] want ={2,4,4,5,1};
        int ans = solution(gift, want);
        System.out.println(ans);
    }
    public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        int cnt = 0;
        int size = gift_cards.length;
        boolean[] chk = new boolean[size+1];
        for (int i = 0; i < size; i++) {
            if(gift_cards[i] == wants[i]) {
                chk[wants[i]] = true;
                cnt++;
                continue;
            }

            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (!chk[wants[i]] && gift_cards[j] == wants[i]) { // 원하는 선물을 찾았으면 i랑 j랑 자리 바꾸기
                    int tmp = gift_cards[i];
                    gift_cards[i] = gift_cards[j];
                    gift_cards[j] = tmp;
                    chk[wants[i]] = true;
                    cnt++;
                }
            }
        }
        answer = size-cnt;
        return answer;
    }
}
