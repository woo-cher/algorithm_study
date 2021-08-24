package programmers.level2.괄호회전하기;

import java.util.Stack;

public class Main {
    public static int solution(String s) {
        int answer = 0;
        int limit = s.length();

        // x == 0
        if (isValid(s)) {
            answer++;
        }

        // 1 <= x <= limit
        for (int i = 1; i < limit; i++) {
            s = rotate(s);

            if (isValid(s)) {
                answer++;
            }
        }

        return answer;
    }

    public static String rotate(String s) {
        char c = s.charAt(0);
        String s2 = s.substring(1);

        return (s2 + c);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            switch (stack.peek()) {
                case '(':
                    if (c == ')') {
                        stack.pop();
                        break;
                    }
                case '{':
                    if (c == '}') {
                        stack.pop();
                        break;
                    }
                case '[':
                    if (c == ']') {
                        stack.pop();
                        break;
                    }
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        System.out.println(solution(s));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }
}
