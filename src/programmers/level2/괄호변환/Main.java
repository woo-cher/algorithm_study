package programmers.level2.괄호변환;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        isCorrect("(()())()");

        String s1 = "()))((()";
        String s2 = ")()()))(((";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    public static String solution(String p) {
        if (isCorrect(p)) {
            return p;
        }

        return divide(p);
    }

    public static String divide(String str) {
        int left = 0;
        int right = 0;

        StringBuilder u = new StringBuilder();
        String v = "";

        if (str.isEmpty()) {
            return str;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                right++;
            } else {
                left++;
            }

            u.append(c);

            if (left == right) {
                v = str.substring(i + 1);
                break;
            }
        }

        if (!isCorrect(u.toString())) {
            String cut = u.substring(1, u.length() - 1).replaceAll("\\(", ".");
            cut = cut.replaceAll("\\)", "(");
            cut = cut.replaceAll("\\.", ")");

            return "(" + v + ")" + cut;
        }

        return u + divide(v);
    }

    public static boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
