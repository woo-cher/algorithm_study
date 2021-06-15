package programmers.level1.수박수박수;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static String solution(int n) {
        String answer = "";

        if (n == 1) {
            return "수";
        }

        if (n == 2) {
            return "수박";
        }

        for (int i = 0; i < (n + 1) / 2; i++) {
            answer += "수박";
        }

        if (n % 2 != 0) {
            answer = answer.substring(0, answer.length() - 1);
        }

        return answer;
    }
}
