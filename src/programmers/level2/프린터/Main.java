package programmers.level2.프린터;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2};
        int l = 2;
        System.out.println(solution(arr, 2));

        int[] arr2 = {1, 1, 9, 1, 1, 1};
        int l2 = 0;

        System.out.println(solution(arr2, l2));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        int target = location;
        int printed = 0;
        int polled = 0;

        for (int p : priorities) {
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            int front = queue.poll();
            polled++;

            if (canPrint(front, queue)) {
                printed++;

                if (target == polled - 1) {
                    break;
                }
            } else {
                queue.add(front);
            }

            if (target == polled - 1) {
                polled = 0;
                target = priorities.length - printed - 1;
            }
        }

        return printed;
    }

    public static boolean canPrint(int polled, Queue<Integer> priorities) {
        if (priorities.isEmpty()) {
            return true;
        }

        for (int priority : priorities) {
            if (priority > polled) {
                return false;
            }
        }

        return true;
    }
}
