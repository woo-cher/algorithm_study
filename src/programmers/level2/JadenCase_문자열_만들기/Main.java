package programmers.level2.JadenCase_문자열_만들기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static String solution(String s) {
        return Arrays.stream(s.split(" ", -1))
                .map(str -> {
                    if (str.isEmpty()) { // 공백 문자이면
                        return str;
                    }

                    if (Character.isAlphabetic(str.charAt(0))) { // 시작문자가 영문이면
                        return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1).toLowerCase();
                    }

                    return str.toLowerCase(); // 시작문자가 영문이 아니면
                })
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution(" for the last week"));
        System.out.println(solution("  A  sDF fFt  "));
    }
}
