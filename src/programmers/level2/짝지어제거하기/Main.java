package programmers.level2.짝지어제거하기;

import java.util.Stack;

/**
 * 스텍 (Stack)
 *  - 괄호 제거하기와 비슷한 유형임
 *  - 스트링 연산작업은 효율성이 높지 않음
 *  - 스텍을 이용하면 시간복잡도 O(n) 로 해결 가능하다
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("bcbc"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0) {
            return 0;
        }

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
