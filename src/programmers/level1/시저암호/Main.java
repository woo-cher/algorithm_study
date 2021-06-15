package programmers.level1.시저암호;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("bC", 25));
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char pushed = ' ';

            if (original == ' ') {
                answer += original;
                continue;
            }

            int actual = Character.isUpperCase(original) ? (int) 'A' : (int) 'a';
            int sub = (actual + 25) - original;

            if (sub < n) {
                pushed = (char) (actual + (n - 1 - sub));
            } else {
                pushed = (char) ((int) original + n);
            }

            answer += pushed;
        }

        return answer;
    }
}
