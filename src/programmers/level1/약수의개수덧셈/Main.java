package programmers.level1.약수의개수덧셈;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i < right + 1; i++) {
            int measuer = 0;

            for (int j = 1; j < i + 1; j++) {
                if (i % j == 0) {
                    measuer++;
                }
            }

            if (measuer % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }
}
