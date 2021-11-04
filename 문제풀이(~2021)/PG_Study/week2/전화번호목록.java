package study_week2;

import java.util.Arrays;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))) return false;
        }
        return true;
    }
}
