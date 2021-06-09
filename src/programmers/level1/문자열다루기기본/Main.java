package programmers.level1.문자열다루기기본;

public class Main {
    public static void main(String[] args) {
        solution("1234");
    }

    public static boolean solution(String s) {
        boolean answer = true;

        int length = s.length();

        if ((length == 4 || length == 6) && s.replaceAll("[0-9]+", "").length() == 0) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}
