package programmers.level2.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3과 30을 일반적인 내림차순으로 정렬 시, 303이 나온다.
 * 하지만 실질적으로 330이 더 큰 수
 *
 * 일반적으로 4, 30, 3을 내림차순 정렬하면 4, 30, 3이 나옴.
 * 가장 큰 수를 출력하기 위해서는 4330 이 나와야한다.
 * 따라서, String 정렬 시에 Comparator 규칙을 커스텀
 */
public class Main {
    public static void main(String[] args) {
        String[] test = {"3", "30", "4"};
        Arrays.sort(test, Comparator.reverseOrder());

        for (String s : test) {
            System.out.println(s);
        }

        int[] input = {6, 10, 2};
        int[] input2 = {3, 30, 34, 5, 9};
        int[] input3 = {3, 30, 300};
        int[] input4 = {0, 0, 0, 0};

        System.out.println(solution(input));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
    }

    public static String solution(int[] numbers) {
        String[] strs = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        String result = String.join("", strs);

        return result.replaceAll("0", "").isEmpty() ? "0" : result;
    }
}
