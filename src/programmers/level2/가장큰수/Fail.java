package programmers.level2.가장큰수;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 시간초과, 메모리초과
 */
public class Fail {
    public static void main(String[] args) {
        int[] input = {6, 10, 2};
        System.out.println(solution(input));
    }

    public static String solution(int[] numbers) {
        List<String> joint = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        boolean[] visited = new boolean[numbers.length];

        permutation(numbers, buffer, joint, visited, 0);

        joint.sort(Comparator.reverseOrder());

        return joint.get(0);
    }

    public static void permutation(int[] input, List<String> buffer, List<String> results, boolean[] visited, int depth) {
        if (depth == input.length) {
            String joint = buffer.stream().collect(Collectors.joining());
            results.add(joint);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                String toString = String.valueOf(input[i]);

                if (buffer.size() != input.length) {
                    buffer.add(toString);
                } else {
                    buffer.set(depth, toString);
                }

                permutation(input, buffer, results, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
