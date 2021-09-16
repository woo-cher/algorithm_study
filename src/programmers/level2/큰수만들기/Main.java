package programmers.level2.큰수만들기;

import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();

        while (k != 0) {
            for (int i = 0; i < number.length(); i++) {
                int actual = number.charAt(i) - '0';

                if (stack.isEmpty() || k == 0) {
                    stack.push(actual);
                    continue;
                }

                if (stack.peek() < actual) {
                    k = compare(stack, actual, k);
                }

                stack.push(actual);
            }

            // loop 를 모두 돌았는데도 k 가 0이 아닌 경우 (같은 숫자의 반복으로 제거하지 못한 경우)
            if (k != 0) {
                for (int i = 0; i < k; i++) {
                    stack.pop();
                }

                break;
            }
        }

        answer = stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return answer;
    }

    public static int compare(Stack<Integer> stack, int actual, int k) {
        while (!stack.isEmpty() && stack.peek() < actual) {
            if (k == 0) {
                break;
            }

            stack.pop();
            k--;
        }

        return k;
    }

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String number2 = "4177252841";
        int k2 = 4;
        String number3 = "1231234";
        int k3 = 3;
        String number4 = "1000";
        int k4 = 1;
        String number5 = "7777777";
        int k5 = 2;
//        System.out.println(solution(number, k));
//        System.out.println(solution(number2, k2));
//        System.out.println(solution(number3, k3));
//        System.out.println(solution(number4, k4));
        System.out.println(solution(number5, k5));
    }
}
