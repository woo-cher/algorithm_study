package programmers.level2.H_Index;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static int solution(int[] citations) {
        int answer = 0;

        int[] sorted = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        for (int n : sorted) {
            if (answer + 1 > n) {
                break;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        int[] arr2 = {10, 8, 5, 4, 3};
        int[] arr3 = {25, 8, 5, 3, 3};
        solution(arr2);
    }
}
