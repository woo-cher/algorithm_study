package programmers.level2.더맵게;

import java.util.*;

/**
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	통과 (5.72ms, 53.3MB)
 * 테스트 3 〉	실패 (런타임 에러)
 * 테스트 4 〉	통과 (5.00ms, 53.3MB)
 * 테스트 5 〉	통과 (6.33ms, 51.8MB)
 * 테스트 6 〉	통과 (57.77ms, 54.7MB)
 * 테스트 7 〉	통과 (37.21ms, 53.8MB)
 * 테스트 8 〉	실패 (런타임 에러)
 * 테스트 9 〉	통과 (11.36ms, 52MB)
 * 테스트 10 〉	통과 (37.65ms, 53.3MB)
 * 테스트 11 〉	실패 (시간 초과)
 * 테스트 12 〉	통과 (79.33ms, 54.8MB)
 * 테스트 13 〉	통과 (41.29ms, 54.3MB)
 * 테스트 14 〉	실패 (런타임 에러)
 * 테스트 15 〉	실패 (시간 초과)
 * 테스트 16 〉	실패 (런타임 에러)
 *
 * :: 런타임 에러가 났던 것들은, 스택의 index 예외처리와 관련된 것 같다.
 *
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 */
public class FirstTry {
    public static void main(String[] args) {
        int[] sove = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(sove, K));
    }

    public static int solution(int[] scoville, int K) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        int answer = 0;

        Integer[] sortedScoville = Arrays.stream(scoville)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);

        for (int scov : sortedScoville) {
            stack.push(scov);
        }

        while (true) {
            int mixed = 0;

            if (stack.size() == 1) {
                if (stack.peek() < K) {
                    answer = -1;
                    break;
                }
            }

            if (validate(stack, K)) {
                break;
            }

            mixed = mix(stack.pop(), stack.pop());
            sort(stack, tempStack, mixed);
            answer++;
        }

        return answer;
    }

    private static void sort(Stack<Integer> stack, Stack<Integer> tempStack, int mixed) {
        while (true) {
            if (stack.peek() < mixed) {
                while (true) {
                    if (stack.empty()) {
                        break;
                    }

                    if (stack.peek() >= mixed) {
                        break;
                    }

                    tempStack.push(stack.pop());
                }

                stack.push(mixed);

                while (!tempStack.empty()) {
                    stack.push(tempStack.pop());
                }

                break;
            }
        }
    }

    public static boolean validate(Stack<Integer> scovStack, int criteria) {
        for (int scov : scovStack) {
            if (scov < criteria) {
                return false;
            }
        }

        return true;
    }

    public static int mix(int first, int second) {
        return first + (second * 2);
    }
}
