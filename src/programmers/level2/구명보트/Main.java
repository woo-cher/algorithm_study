package programmers.level2.구명보트;

import java.util.Arrays;

public class Main {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int p = 0, q = people.length - 1;

        Arrays.sort(people);

        while (p <= q) {
            answer += 1;

            if (p == q) {
                break;
            }

            if (people[p] + people[q] <= limit) { // 둘이 보낼 수 있나?
                p++;
                q--;
            } else { // 무거운 놈 먼저 보내기
                q--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 5, 7, 7, 4}, 10));
        System.out.println(solution(new int[]{50, 70, 80}, 100));
    }
}
