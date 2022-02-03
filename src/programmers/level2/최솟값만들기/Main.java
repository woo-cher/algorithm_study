package programmers.level2.최솟값만들기;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> min = new PriorityQueue<>();

        for (int n : A) {
            max.add(n);
        }

        for (int n : B) {
            min.add(n);
        }

        while (!max.isEmpty()) {
            answer += min.poll() * max.poll();
        }

        return answer;
    }
}
