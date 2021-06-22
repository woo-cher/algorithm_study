package programmers.level1.콜라츠추측;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int answer = 0;
        long input = num;

        while (true) {
            if (input == 1) {
                break;
            }

            if (answer > 499) {
                answer = -1;
                break;
            }

            if (input % 2 == 0) {
                input = input / 2;
            } else {
                input = input * 3 + 1;
            }

            answer++;
        }

        return answer;
    }
}
