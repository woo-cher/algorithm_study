package programmers.level2.타겟넘버;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐(Queue, FIFO) 를 이용해 모든 경우를 탐색
 *
 *  1. value, index 를 구성하는 클래스를 구성한다
 *  2. 큐에 최초값으로 +첫번째 값, -첫번째 값을 넣는다.
 *  3. 큐가 비어있지 않으면 루프를 도는데, 큐에서 뺀 값에 인덱스를 검사한다.
 *  4. 최종 인덱스까지 갔을 때, target 과 비교한다.
 *  5. 최종 인덱스가 아니라면, 큐에 다음 인자를 더한 값과 뺀 값들을 각각 넣어준다. 물론 인덱스도 하나 올린다.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 2}, 2));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<Pair>();

        queue.add(new Pair(numbers[0], 0));
        queue.add(new Pair(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.getIndex() == numbers.length - 1) {
                if (p.getValue() == target) {
                    answer += 1;
                }

                continue;
            }

            int c1 = p.getValue() + numbers[p.getIndex() + 1];
            int c2 = p.getValue() - numbers[p.getIndex() + 1];

            queue.add(new Pair(c1, p.getIndex() + 1));
            queue.add(new Pair(c2, p.getIndex() + 1));
        }

        return answer;
    }
}

class Pair {
    private int val;
    private int i;

    Pair(int val, int i) {
        this.val = val;
        this.i = i;
    }

    public int getValue() {
        return val;
    }

    public int getIndex() {
        return i;
    }
}
