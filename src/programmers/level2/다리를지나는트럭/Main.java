package programmers.level2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int l = bridge_length;
        int w = weight;

        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> passed = new LinkedList<>();
        Queue<Integer> passing = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waiting.add(truck_weights[i]);
        }

        while (passed.size() != truck_weights.length) {
            answer++;

            // 도착처리
            if (passing.size() == bridge_length) {
                int arrived = passing.poll();
                if (arrived != 0) {
                    passed.add(arrived);
                    l++;
                    w += arrived;
                }
            }

            // 출발처리
            int truck = !waiting.isEmpty() ? waiting.peek() : w + 1;
            if (l != 0 && w - truck >= 0) { // 위에 대기열이 없으면, w + 1 로 처리해서 else 문으로
                w -= truck;
                l--;
                passing.add(truck);
                waiting.poll();
            } else {
                passing.add(0);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int l = 100;
        int w = 100;
        int[] arr = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(solution(l, w, arr));
    }
}
