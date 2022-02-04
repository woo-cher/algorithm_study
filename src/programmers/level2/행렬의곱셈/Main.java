package programmers.level2.행렬의곱셈;

import java.util.Arrays;

public class Main {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        int floor = 0;
        while (floor < arr1.length) {
            for (int i = 0; i < arr2[0].length; i++) {
                int n = 0;
                for (int j = 0; j < arr2.length; j++) {
                    n += arr1[floor][j] * arr2[j][i];
                }

                answer[floor][i] = n;
            }

            floor++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1}, {2}, {3}, {4}}, new int[][]{{1, 2, 3, 4}})));
//        System.out.println(solution(new int[][]{{1, 2, 3, 4}}, new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}));
    }
}
