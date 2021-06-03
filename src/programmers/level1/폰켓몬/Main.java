package programmers.level1.폰켓몬;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int kinds = 0;
        int canSelect = 0;

        Map<Integer, Integer> noneOverlaps = new HashMap<>();

        for (int num : nums) {
            if (!noneOverlaps.containsKey(num)) {
                noneOverlaps.put(num, num);
            }
        }

        canSelect = nums.length / 2;
        kinds = noneOverlaps.size();

        if (kinds <= canSelect) {
            answer = kinds;
        } else {
            answer = canSelect;
        }

        return answer;
    }
}
