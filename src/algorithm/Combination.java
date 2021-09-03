package algorithm;

public class Combination {
    public static String[] input = {"A", "B", "C"};

    public static void main(String[] args) {
//        for (int r = 1; r < input.length + 1; r++) {
//            combination("", 0, r);
//        }

        System.out.println("\n──────────────────────────────────────────────────────");

        for (int r = 1; r < input.length + 1; r++) {
            combWithDupl("", 0, r);
        }
    }

    /**
     *  중복을 허용하지 않으므로, 다음 호출 시 뽑은 인덱스 i 다음 것으로 재귀 호출
     */
    public static void combination(String s, int start, int r) {
        if (r == 0) {
            System.out.println(s);
            return;
        }

        for (int i = start; i < input.length; i++) {
            combination(s + input[i], i + 1, r - 1);
        }
    }

    /**
     *  중복을 허용하므로, 다음 호출 시 인덱스 i 를 그대로 넘김
     */
    public static void combWithDupl(String s, int start, int r) {
        if (r == 0) {
            System.out.println(s);
            return;
        }

        for (int i = start; i < input.length; i++) {
            combWithDupl(s + input[i], i, r - 1);
        }
    }
}
