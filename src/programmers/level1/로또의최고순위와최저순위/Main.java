package programmers.level1.로또의최고순위와최저순위;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {}

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int unKnowns = 0;
        int matched = 0;

        Map<Integer, Integer> winMap = new HashMap();

        for (int num : win_nums) {
            winMap.put(num, num);
        }

        for (int num : lottos) {
            if (num == 0) {
                unKnowns++;
            } else if (winMap.containsKey(num)) {
                matched++;
            }
        }

        if (unKnowns == 0 && matched == 0) {
            answer = new int[]{6, 6};
        } else if (unKnowns == 6) {
            answer = new int[]{1, 6};
        } else {
            answer = new int[]{(6 - (matched + unKnowns)) + 1, (6 - matched) + 1};
        }

        return answer;
    }
}
