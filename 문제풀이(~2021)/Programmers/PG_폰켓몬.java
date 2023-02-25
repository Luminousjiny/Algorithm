package day0721;

import java.util.HashSet;
import java.util.Set;

public class PG_폰켓몬 {
    public static void main(String[] args) {
        int[] n = {1,2,3,3};
        int ans = solution(n);
        System.out.println(ans);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int origin = nums.length/2;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size() < origin) answer = set.size();
        else answer = origin;
        return answer;
    }
}
