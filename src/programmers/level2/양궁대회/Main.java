package programmers.level2.양궁대회;

import java.util.Arrays;

public class Main {
    public static int score = -1;
    public static int[] answer = {};

    public static int[] solution(int n, int[] info) {
        int[] arr = new int[11];

        dfs(0, n, info, arr);

        if (score <= 0) {
            return new int[]{-1};
        }

        return answer;
    }

    public static void dfs(int depth, int arrow, int[] info, int[] arr) {
        int[] ryan = Arrays.copyOf(arr, arr.length);
        int remainArrow = arrow;

        if (depth == info.length || arrow == 0) {
            ryan[info.length - 1] = depth == info.length ? arrow : ryan[info.length - 1];

            int subScore = getSubScore(info, arr);

            if (subScore > score) {
                score = subScore;
                answer = Arrays.copyOf(ryan, ryan.length);
            } else if (subScore == score) {
                doCompare(answer, ryan);
            }

            return;
        }

        int apache = info[depth];

        if (arrow > apache) {
            remainArrow -= apache + 1;
            ryan[depth] = apache + 1;
            dfs(depth + 1, remainArrow, info, ryan);
            ryan[depth] = 0;
        }

        dfs(depth + 1, arrow, info, ryan);
    }

    public static void doCompare(int[] original, int[] ryan) {
        for (int i = original.length - 1; i >= 0; i--) {
            if (original[i] > ryan[i]) {
                answer = Arrays.copyOf(original, original.length);
                return;
            } else if (original[i] < ryan[i]){
                answer = Arrays.copyOf(ryan, ryan.length);
                return;
            }
        }
    }

    public static int getSubScore(int[] info, int[] answer) {
        int result = 0;

        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (info[i] == 0 && answer[i] == 0) {
                continue;
            }

            if (info[i] >= answer[i]) {
                result -= score;
                continue;
            }

            result += score;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
//        System.out.println(Arrays.toString(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }
}
