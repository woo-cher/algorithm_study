package programmers.level2.타겟넘버;

/**
 *  재귀(Recursion)를 통한 모든 경우를 탐색
 *
 *   1. 0번째 값을 최초 값으로 넣고, depth 는 0으로 준다.
 *   2. 재귀에서, depth 값과 length 값을 검사해서 target 과 일치하는지 판단하고 리턴값을 내준다.
 *   3. depth 를 한 단계 올리고, 바로 다음 인덱스 값을 더한 값으로 재귀를 호출한다.
 *   4. depth 를 한 단계 올리고, 바로 다음 인덱스 값을 뺀 값으로 재귀를 호출한다.
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 2}, 2));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer += recursion(0, numbers[0], numbers, target);
        answer += recursion(0, -numbers[0], numbers, target);

        return answer;
    }

    public static int recursion(int depth, int value, int[] numbers, int target) {
        if (depth == numbers.length - 1) {
            return value == target ? 1 : 0;
        }

        int answer = 0;

        answer += recursion(depth + 1, value + numbers[depth + 1], numbers, target);
        answer += recursion(depth + 1, value - numbers[depth + 1], numbers, target);

        return answer;
    }
}
