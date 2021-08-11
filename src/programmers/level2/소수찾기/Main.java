package programmers.level2.소수찾기;

import java.util.*;

public class Main {
    public static List<Boolean> primeMap = new ArrayList<>();
    public static Set<Integer> comb = new HashSet<>();
    public static int MAX_VALUE = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String s = "17";
        System.out.println(solution(s));
    }

    public static int solution(String numbers) {
        int answer = 0;

        for (int r = 1; r <= numbers.length(); r++) {
            per(numbers.toCharArray(), new StringBuffer(), new boolean[numbers.length()], 0, r);
        }

        // 소수맵 initialize
        primeMap.add(false);
        primeMap.add(false);

        for (int i = 2; i <= MAX_VALUE; i++) {
            primeMap.add(true);
        }

        for (int i = 2; i * i <= MAX_VALUE; i++) {
            if (primeMap.get(i)) {
                for (int j = i * i; j <= MAX_VALUE; j += i) {
                    primeMap.set(j, false);
                }
            }
        }

        for (int n : comb) {
            if (primeMap.get(n)) {
                answer++;
            }
        }

        return answer;
    }

    public static void per(char[] input, StringBuffer buffer, boolean[] visited, int depth, int r) {
        if (depth == r) {
            int n = Integer.parseInt(
                    removeZeroPrefix(buffer.toString())
            );

            MAX_VALUE = Math.max(MAX_VALUE, n);
            comb.add(n);

            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer.replace(depth, depth + 1, String.valueOf(input[i]));
                per(input, buffer, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static String removeZeroPrefix(String s) {
        while (s.startsWith("0")) {
            s = s.replaceFirst("0", "");
        }

        return s.isEmpty() ? "0" : s;
    }
}
