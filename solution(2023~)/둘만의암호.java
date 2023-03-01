package Lv1.day0301;

public class 둘만의암호 {
    public static void main(String[] args) {
        String ans = solution("aukks", "wbqd", 5);
        System.out.println(ans);
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";
        char[] word = s.toCharArray();
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < index; j++) {
                while (true){
                    word[i]++;
                    if(word[i] > 'z') word[i] -= 26;
                    if(!skip.contains(Character.toString(word[i]))){
                        break;
                    }
                }
            }
        }
        for (Character c : word) {
            answer += Character.toString(c);
        }
        return answer;
    }
}
