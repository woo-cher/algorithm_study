package programmers.level2.문자열압축;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }

    public static int solution(String s) {
        Stack<String> stack = new Stack<>();
        int minimum = 1000;

        if (s.length() == 1) {
            return 1;
        }

        for (int unit = s.length() / 2; unit > 0; unit--) {
            String result = "";
            String[] splited = split(s, unit);
            int count = 1;

            stack.push(splited[0]);

            for (int i = 1; i < splited.length; i++) {
                if (result.length() > minimum) {
                    break;
                }

                if (stack.peek().equals(splited[i])) {
                    count++;
                } else {
                    result += compression(stack.pop(), count);
                    stack.push(splited[i]);
                    count = 1;
                }

                if (i == splited.length - 1) {
                    result += compression(stack.pop(), count);
                }
            }

            if (result.length() < minimum) {
                minimum = result.length();
            }
        }

        return minimum;
    }

    public static String[] split(String s, int unit) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = unit;

        while (true) {
            list.add(s.substring(start, end));

            if (end + unit >= s.length()) {
                list.add(s.substring(end));
                break;
            }

            start += unit;
            end += unit;
        }

        return list.toArray(String[]::new);
    }

    public static String compression(String target, int count) {
        if (count == 1) {
            return target;
        }

        return String.valueOf(count).concat(target);
    }
}
