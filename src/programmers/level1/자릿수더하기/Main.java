package programmers.level1.자릿수더하기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(987));
    }

    public static int solution(int n) {
        String toStr = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < toStr.length(); i++) {
            sum += toStr.charAt(i) - '0';
        }

        return sum;
    }
}
