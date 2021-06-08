package programmers.level1.삼진법뒤집기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(125));
        System.out.println(solution(45));
    }

    public static int solution(int n) {
        String str = "";

        while (true) {
            if (n == 0) {
                break;
            }

            str = String.valueOf(n % 3) + str;
            n = n / 3;
        }

        StringBuilder builder = new StringBuilder(str);
        String reversed = builder.reverse().toString();

        return Integer.parseInt(reversed, 3);
    }
}
