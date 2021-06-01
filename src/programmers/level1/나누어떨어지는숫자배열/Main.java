package programmers.level1.나누어떨어지는숫자배열;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        sub(new int[]{3,2,6}, 10);
    }

    public static int[] sub(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(n -> n % divisor == 0)
                .sorted()
                .toArray();

        if(answer.length == 0) {
            answer = new int[]{-1};
        }

        return answer;
    }
}
