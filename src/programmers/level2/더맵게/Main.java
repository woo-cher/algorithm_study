package programmers.level2.더맵게;

import java.util.PriorityQueue;

/**
 * 우선순위 큐 (PriorityQueue)
 */
public class Main {
    public static void main(String[] args) {
        int[] sove = new int[]{1, 2, 9, 3, 12, 10};
        int K = 7;

        System.out.println(solution(sove, K));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for (int scov : scoville) {
            queue.add(scov);
        }

        while (true) {
            if (queue.size() == 1) {
                if (queue.peek() < K) {
                    answer = -1;
                    break;
                }
            }

            if (validate(queue, K)) {
                break;
            }

            int mixed = mix(queue.poll(), queue.poll());
            queue.add(mixed);
            answer++;
        }

        return answer;
    }

    public static boolean validate(PriorityQueue<Integer> q, int matcher) {
        for (int n : q) {
            if (n < matcher) {
                return false;
            }
        }

        return true;
    }

    public static int mix(int minValue, int secondMinValue) {
        return minValue + (secondMinValue * 2);
    }
}
