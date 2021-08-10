package programmers.level2.수식최대화;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static long MAX_VALUE = Long.MIN_VALUE;
    public static List<String> CASE_OF_SIGNS = new ArrayList<>();

    public static void main(String[] args) {
        String a = "50*6-3*2";
        String b = "100-200*300-500+20";
        String c = "100+500-600+700";
        String d = "2*2*2*2*2-2*2*2";

        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
    }

    public static long solution(String expression) {
        List<String> signs = new ArrayList<>();
        List<Long> nums = new ArrayList<>();
        String numStr = "";

        String nonNumber = expression.replaceAll("[0-9]", "");

        for (int i = 0; i < nonNumber.length(); i++) {
            String sign = String.valueOf(nonNumber.charAt(i));

            if (!CASE_OF_SIGNS.contains(sign)) {
                CASE_OF_SIGNS.add(sign);
            }
        }

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                signs.add(c + "");
                nums.add(Long.parseLong(numStr));
                numStr = "";
            } else {
                numStr += c;
            }
        }

        nums.add(Long.parseLong(numStr)); // last number
        permutation(signs, nums, new StringBuffer(), new boolean[CASE_OF_SIGNS.size()], 0);

        return MAX_VALUE;
    }

    public static void permutation(List<String> signs, List<Long> nums, StringBuffer buffer, boolean[] visited, int depth) {
        if (depth == CASE_OF_SIGNS.size()) {
            operate(buffer, signs, nums);
            return;
        }

        for (int i = 0; i < CASE_OF_SIGNS.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer.replace(depth, depth + 1, CASE_OF_SIGNS.get(i));
                permutation(signs, nums, buffer, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void operate(StringBuffer buffer, List<String> signs, List<Long> nums) {
        List<String> signsTemp = new ArrayList<>(signs);
        List<Long> numsTemp = new ArrayList<>(nums);

        for (int i = 0; i < buffer.length(); i++) {
            String prioritySign = buffer.charAt(i) + ""; // ex) buffer : "+-*", "*-+" ...

            for (int j = 0; j < signsTemp.size(); j++) {
                String sign = signsTemp.get(j);

                if (signsTemp.get(j).equals(prioritySign)) {
                    long result = calculate(numsTemp.get(j), numsTemp.get(j + 1), sign);

                    signsTemp.remove(j);
                    numsTemp.remove(j + 1); // +1 index 를 먼저 제거해야 idx 가 안꼬임
                    numsTemp.remove(j);

                    numsTemp.add(j, result);
                    j--;
                }
            }
        }

        long abs = Math.abs(numsTemp.get(0));
        MAX_VALUE = Math.max(MAX_VALUE, abs);
    }

    public static long calculate(long n1, long n2, String sign) {
        long result = 0;

        switch (sign) {
            case "+" -> result = n1 + n2;
            case "-" -> result = n1 - n2;
            case "*" -> result = n1 * n2;
        }

        return result;
    }
}
