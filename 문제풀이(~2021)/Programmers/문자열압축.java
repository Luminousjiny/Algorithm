public class 문자열압축 {
    public static int solution(String s) {
        int min = s.length();
        for(int i=1; i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String before = s.substring(0, i);
            int cnt = 1;
            String now = "";
            for(int j=i; j<s.length(); j+=i){
                // 1. 마지막인지 아닌지에 따라 now를 갱신한다.
                if(s.length() < j + i){
                    now = s.substring(j);
                }else{
                    now = s.substring(j, j+i);
                }

                // 2. before과 now를 비교한다.
                if(before.equals(now)) {
                    cnt++;
                }else{
                    if(cnt != 1) sb.append(cnt);
                    sb.append(before);
                    cnt = 1;
                }
                before = now;
            }
            // 3. 마지막에 붙이지 못한 문자열을 붙인다.
            if(cnt != 1) sb.append(cnt);
            sb.append(before);

            String check = sb.toString();
            min = Math.min(min, check.length());
        }
        return min;
    }
}
