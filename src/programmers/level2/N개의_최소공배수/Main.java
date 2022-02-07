package programmers.level2.N개의_최소공배수;

public class Main {
    public static int solution(int[] arr) {
        int answer = 0;

        if (arr.length == 1) {
            return arr[0];
        }

        answer = arr[0] * arr[1] / getGcd(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            answer = answer * arr[i] / getGcd(answer, arr[i]);
        }

        return answer;
    }

    // euclid
    public static int getGcd(int n, int m) {
        if (m == 0) {
            return n;
        }

        return getGcd(m, n % m);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
    }
}
