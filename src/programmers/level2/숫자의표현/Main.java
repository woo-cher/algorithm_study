package programmers.level2.숫자의표현;

public class Main {

    // Normal
    public static int solution(int n) {
        int answer = 1;

        if (n < 2) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            int start = i;
            int sum = i;

            while (true) {
                sum += ++start;

                if (sum > n) {
                    break;
                }

                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    // Sliding Window
    public static int solution2(int n) {
        int answer = 1;
        int left = 1, right = 2, sum = left + right;

        if (n < 3) {
            return 1;
        }

        while (right < n) {
            if (sum < n) {
                sum += ++right;
                continue;
            }

            if (sum == n) {
                answer++;
            }

            sum -= left;
            left++;
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
