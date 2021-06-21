package programmers.level1.제일작은수제거하기;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 1}));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        List<Integer> list = new ArrayList<>();

        for (int n : arr) {
            list.add(n);
        }

        int minValue = list.stream()
                .mapToInt(i -> i)
                .min()
                .getAsInt();

        return list.stream()
                .filter(n -> n != minValue)
                .mapToInt(i -> i)
                .toArray();
    }
}
