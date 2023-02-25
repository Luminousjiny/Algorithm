package day0722;

public class PG_숫자문자열과영단어 {
    public static void main(String[] args) {
        solution("one4seveneight");
    }
    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(now >= '0' && now <= '9'){
                sb.append(now);
            }else if(now == 'z'){ // 0
                sb.append("0");
                i+= 3;
            }else if(now == 'o'){ // 1
                sb.append("1");
                i+= 2;
            }else if(now == 't'){
                if(s.charAt(i+1) == 'w'){ // 2
                    sb.append("2");
                    i+= 2;
                }else if(s.charAt(i+1) == 'h'){ // 3
                    sb.append("3");
                    i+= 4;
                }
            }else if(now == 'f'){
                if(s.charAt(i+1) == 'o'){ // 4
                    sb.append("4");
                    i+= 3;
                }else if(s.charAt(i+1) == 'i'){ // 5
                    sb.append("5");
                    i+= 3;
                }
            }else if(now == 's'){
                if(s.charAt(i+1) == 'i'){ // 6
                    sb.append("6");
                    i+= 2;
                }else if(s.charAt(i+1) == 'e'){ // 7
                    sb.append("7");
                    i+= 4;
                }
            }else if(now == 'e'){ // 8
                sb.append("8");
                i+= 4;
            }else if(now == 'n'){ // 9
                sb.append("9");
                i+= 3;
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}
