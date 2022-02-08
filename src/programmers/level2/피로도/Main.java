package programmers.level2.피로도;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static boolean[] v;

    public static int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        permutation(0, k, dungeons);

        return max;
    }

    public static void permutation(int cnt, int k, int[][] input) {
        for (int i = 0; i < input.length; i++) {
            if (!v[i]) {
                if (k >= input[i][0]) {
                    v[i] = true;
                    permutation( cnt + 1, k - input[i][1], input);
                    v[i] = false;
                }
            }
        }

        max = Math.max(max, cnt);
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
