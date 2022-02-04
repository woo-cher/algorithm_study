package programmers.level2.피보나치수;

public class Main {
    public static int[] memo = {};
    public static int solution(int n) {
        memo = new int[n + 1];
        return fibo(n) % 1234567;
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n] % 1234567;
        }

        // 모듈러 연산 성질에 의해 A + B = C 는 (A % k) + (B % k) = C % k 와 같다.
        memo[n] = fibo(n - 1) % 1234567 + fibo(n - 2) % 1234567;
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
