package programmers.level2.예상대진표;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        // 바로 옆이면
        if (Math.max(a, b) % 2 == 0 && Math.abs(a - b) == 1) {
            return 1;
        }

        while (true) {
            int leftArea = n / 2;

            // 서로 다른 영역인가?
            if (a <= leftArea && b > leftArea) {
                answer = getFinalRound(n);
                break;
            }

            if (a > leftArea && b <= leftArea) {
                answer = getFinalRound(n);
                break;
            }

            // 서로 같은 영역인가?
            n = leftArea;

            if (a > n && b > n) {
                a = Math.abs(n - a);
                b = Math.abs(n - b);
            }
        }

        return answer;
    }

    public static int getFinalRound(int number) {
        int jisu = 0;
        while (number != 1) {
            number = number / 2;
            jisu++;
        }

        return jisu;
    }
}
