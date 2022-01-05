package programmers.level2.다음큰숫자;

public class Main {
    public static int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);

        for (int i = n + 1; ; i++) {
            if (count == Integer.bitCount(i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}
