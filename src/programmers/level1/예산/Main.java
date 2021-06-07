package programmers.level1.예산;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        for (int price : d) {
            if (sum + price > budget) {
                break;
            }

            sum += price;
            answer++;
        }

        return answer;
    }
}
