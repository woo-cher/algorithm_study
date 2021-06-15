package programmers.level1.서울에서김서방찾기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static String solution(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + index + "에 있다";
    }
}
