package programmers.level2.일이사나라의숫자;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static String solution(int n) {
        String answer = "";

        while (true) {
            if (n == 0) {
                break;
            }

            int remain = n % 3;
            int divide = n / 3;

            answer = custom(remain) + answer;
            n = remain == 0 ? divide - 1 : divide;
        }

        return answer;
    }

    public static String custom(int remain) {
        if (remain == 0) {
            return "4";
        }

        return String.valueOf(remain);
    }
}
