package programmers.level1.실패율;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public static int[] solution(int N, int[] stages) {
        List<Double> failureLates = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            int total = 0;
            int noClear = 0;

            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j]) {
                    total++;
                }

                if (i == stages[j]) {
                    noClear++;
                }
            }

            if (total == 0) {
                failureLates.add(.0);
            } else {
                failureLates.add((double) noClear / (double) total);
            }
        }

        while (true) {
            if (answer.size() == failureLates.size()) {
                break;
            }

            int maxIndex = 0;

            for(int i = 1; i < failureLates.size(); i++) {
                double actual = failureLates.get(maxIndex);
                double matcher = failureLates.get(i);

                if (matcher == -1) {
                    continue;
                }

                if (actual < matcher) {
                    maxIndex = i;
                }

                if (actual == matcher) {
                    maxIndex = Math.min(maxIndex, i);
                }
            }

            answer.add(maxIndex + 1);

            if (failureLates.size() != 0) {
                failureLates.set(maxIndex, -1.0);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
