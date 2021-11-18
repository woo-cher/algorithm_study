package programmers.level2.배열자르기;

import java.util.Arrays;

public class Main {
    public static int[] solution(int n, long left, long right) {
        int size = (int) (right - left) + 1;
        int[] answer = new int[size];

        // find (row, col) with index
        for (int i = 0; i < answer.length; i++) {
            long mapper = left + i; // left ~ right
            int row = (int) (mapper / n);
            int col = (int) (mapper % n);

            answer[i] = Math.max(row, col) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }
}
