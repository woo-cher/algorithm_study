package programmers.level2.땅따먹기;

import java.util.Arrays;

public class Main {
    public static int solution(int[][] land) {
        for (int i = 0; i < land.length - 1; i++) {
            int[] next = land[i + 1];

            land[0][0] += getMax(next[1], next[2], next[3]);
            land[0][1] += getMax(next[0], next[2], next[3]);
            land[0][2] += getMax(next[0], next[1], next[3]);
            land[0][3] += getMax(next[0], next[1], next[2]);
        }

        return getMax(land[0][0], land[0][1], land[0][2], land[0][3]);
    }

    public static int getMax(int... n) {
        return Arrays.stream(n).max().orElse(-1);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution(input));
    }
}
