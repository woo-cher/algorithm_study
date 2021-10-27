package programmers.level2.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();

        // init
        for (int p : prices) {
            stack.push(p);
        }

        // loop
        int n = 0;
        int idx = answer.length - 1;

        while (!stack.isEmpty()) {
            int now = stack.pop();
            int sec = 0;

            for (int i = prices.length - n; i < prices.length; i++) {
                sec++;

                if (now > prices[i]) {
                    break;
                }
            }

            answer[idx--] = sec;
            n++;
        }

        return answer;
    }

    public static int[] bruteForce(int[] prices) {
        int[] answer = new int[prices.length];
        int size = prices.length;

        for (int i = 0; i < size; i++) {
            int sec = 0;

            for (int j = i + 1; j < size; j++) {
                sec++;

                if (prices[i] > prices[j]) {
                    break;
                }
            }

            answer[i] = sec;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bruteForce(new int[]{1, 2, 3, 2, 3})));
    }
}
