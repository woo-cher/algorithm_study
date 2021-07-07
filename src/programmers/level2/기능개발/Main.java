package programmers.level2.기능개발;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    /**
     * 1. 완료 우선 순위에 의거한 스텍에 작업 idx 삽입
     * 2. 루프를 돌면서, 작업량 할당
     * 3. 작업량 할당 후, 완료되었는지 확인하는 조건절 추가
     * true : 완료된 작업 발견 시, 앞작업을 배포 할 수 있는지 검사
     * false : 2번 과정부터 반복
     */
    public static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int size = progresses.length;
        int finished = 0;

        for (int i = progresses.length - 1; i > -1; i--) {
            stack.push(progresses[i]);
        }

        while (!stack.isEmpty()) {
            int today = 0;

            for (int i = finished; i < speeds.length; i++) {
                stack.set(size - 1 - i, stack.get(size - 1 - i) + speeds[i]); // (size - 1 - i) -> LIFO
            }

            if (stack.peek() >= 100) {
                while (!stack.isEmpty() && stack.peek() >= 100) {
                    stack.pop();
                    today++;
                    finished++;
                }

                answer.add(today);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
