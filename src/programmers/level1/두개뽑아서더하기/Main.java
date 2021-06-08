package programmers.level1.두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] arr = {};

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = numbers[i] + numbers[j];

                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }

        return list.stream().mapToInt(i -> i).sorted().toArray();
    }
}
