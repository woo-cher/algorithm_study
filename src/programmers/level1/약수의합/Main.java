package programmers.level1.약수의합;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(12));
    }

    public static int solution(int n) {
        int answer = 1 + n;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
