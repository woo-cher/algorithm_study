package programmers.level1.정수내림차순으로배치하기;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        /**
         *  1. n -> 배열로 만든다
         *  2. 배열을 정렬한다
         *  3. 배열을 돌면서 str 로 붙인다
         *  4. str 을 long 으로 바꾼다
         */
        String[] strs = String.valueOf(n).split("");
        Integer[] ints = new Integer[strs.length];
        String str = "";

        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(ints, Collections.reverseOrder());

        for (int a : ints) {
            str += String.valueOf(a);
        }

        return Long.valueOf(str);
    }
}
