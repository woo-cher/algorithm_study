package programmers.level1.체육복;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(sub(5, new int[]{2,4,5}, new int[]{1,4}));
    }

    public static int sub(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Map<Integer, Integer> reserveMap = new HashMap<>();

        // HashMap initialize
        for (int num : reserve) {
            reserveMap.put(num, num);
        }

        /**
         * 1) 여유분 있는 사람이 도둑 맞음 -> 빌려줄 수 없으나, 수업은 들을 수 있다.
         * 2) 자기 번호 - 1 인 친구가 여유분이 있는가?
         * 3) 자기 번호 + 1 인 친구가 여유분이 있는가?
         */
        for (int i = 0; i < lost.length; i++) {
            if (reserveMap.containsKey(lost[i])) {
                answer++;
                reserveMap.remove(lost[i]);
                continue;
            }

            if (reserveMap.containsKey(lost[i] - 1)) {
                reserveMap.remove(lost[i] - 1);
                answer++;
            }

            else if (reserveMap.containsKey(lost[i] + 1)) {
                reserveMap.remove(lost[i] + 1);
                answer++;
            }
        }
        return answer;
    }
}
