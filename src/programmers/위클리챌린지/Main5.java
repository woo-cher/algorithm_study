package programmers.위클리챌린지;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 5 주차
public class Main5 {
    public static String[] input = {"A", "E", "I", "O", "U"};

    public static int solution(String word) {
        List<String> list = new ArrayList<>();

        for (int r = 1; r < input.length + 1; r++) {
            perWithDupl(list, "", 0, r);
        }

        Collections.sort(list);
        return list.indexOf(word) + 1;
    }

    public static void perWithDupl(List<String> list, String s, int depth, int r) {
        if (depth == r) {
            list.add(s);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            perWithDupl(list, s + input[i], depth + 1, r);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("I"));
    }
}
