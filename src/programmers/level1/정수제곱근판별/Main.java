package programmers.level1.정수제곱근판별;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(49));
        System.out.println(solution(50));
    }

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);
        String sqrtStr = String.valueOf(sqrt);
        int dotIndex = sqrtStr.indexOf(".");

        if (sqrtStr.substring(dotIndex + 1).length() != 1) {
            return -1;
        }

        return (long) Math.pow((long) sqrt + 1, 2);
    }
}
