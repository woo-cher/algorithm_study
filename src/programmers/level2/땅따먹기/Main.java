package programmers.level2.땅따먹기;

import java.util.Arrays;

public class Main {
    // dp
    public static int solution(int[][] land) {
        int N = land.length;

        for (int i = 1; i < N; i++) {
            int[] prev = land[i - 1];

            land[i][0] += getMax(prev[1], prev[2], prev[3]);
            land[i][1] += getMax(prev[0], prev[2], prev[3]);
            land[i][2] += getMax(prev[0], prev[1], prev[3]);
            land[i][3] += getMax(prev[0], prev[1], prev[2]);
        }

        return Arrays.stream(land[N - 1]).max().orElse(-1);
    }

    public static int getMax(int... n) {
        return Math.max(n[0], Math.max(n[1], n[2]));
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution(input));
    }
}
