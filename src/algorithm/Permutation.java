package algorithm;

public class Permutation {
    public static String[] input = {"A", "B", "C"};
    public static int loop = 0;

    public static void main(String[] args) {
//        for (int r = 1; r < input.length + 1; r++) {
//            perWithDupl("", r, 0);
//        }
//        System.out.println("──────────────────────────────────────────────────────");

        for (int r = 1; r < input.length + 1; r++) {
            permutation("", r, 0, new boolean[input.length]); // 1 ~ 3개 줄세울 때, loop 횟수 30 번
        }

//        per("", new boolean[input.length]);
        System.out.println(loop);
    }

    public static void per(String s, boolean[] v) { // 1 ~ 3개 줄세울 때, loop 횟수 16 번
        for (int i = 0; i < input.length; i++) {
            if (!v[i]) {
                v[i] = true;
                per(s + input[i], v);
                v[i] = false;
            }
        }

        if (s.length() == 2) {
            System.out.println(s);
        }
    }

    // 순열
    public static void permutation(String s, int r, int depth, boolean[] v) {
        if (depth == r) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!v[i]) {
                v[i] = true;
                permutation(s + input[i], r, depth + 1, v);
                v[i] = false;
            }
        }
    }

    // 중복 순열
    public static void perWithDupl(String s, int r, int depth) {
        if (depth == r) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            perWithDupl(s + input[i], r, depth + 1);
        }
    }
}
