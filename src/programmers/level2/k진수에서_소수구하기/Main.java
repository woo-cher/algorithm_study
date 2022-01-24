package programmers.level2.k진수에서_소수구하기;

public class Main {
    public static int solution(int n, int k) {
        int answer = 0;
        String[] arr = convertToK(n, k).split("0");

        for (String s : arr) {
            if (s.isEmpty()) {
                continue;
            }

            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    public static String convertToK(int n, int k) {
        if (k == 10) {
            return String.valueOf(n);
        }

        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            builder.insert(0, n % k);
            n = n / k;
        }

        return builder.toString();
    }

    public static boolean isPrime(long limit) {
        if (limit == 0 || limit == 1) {
            return false;
        }

        for (long i = 2; i < Math.sqrt(limit); i++) {
            if (limit % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }
}
