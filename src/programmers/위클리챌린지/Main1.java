package programmers.위클리챌린지;

// 위클리 챌린지 1주차
public class Main1 {
    public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;

        for (int i = 1; i < count + 1; i++) {
            sum += (long) price * i;
        }

        answer = sum - money;

        return answer < 0 ? 0 : answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
}
