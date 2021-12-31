package programmers.level2.올바른괄호;

public class Main {
    static boolean solution(String s) {
        int n = 0;

        if (s.startsWith(")")) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            n += c == '(' ? 1 : -1;

            if (n < 0) {
                return false;
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
