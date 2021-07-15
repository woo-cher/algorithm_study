package programmers.level2.튜플;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String s = "{{2},{2,1},{2,1,3,4},{2,1,3}}";
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3,4,1,43},{2,3}}";
        System.out.println(solution2(s));
    }

    public static int[] solution(String s) {
        String input = s.substring(2, s.length() - 2);
        String[] tuples = input.split("},\\{");

        Stack<String> stack = new Stack<>();
        Stack<String> tmpStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // sort
        for (String el : tuples) {
            sortStack(stack, tmpStack, el);
        }

        // validate
        while (!stack.isEmpty()) {
            String tuple = stack.pop();

            for (String el : tuple.split(",")) {
                Integer elI = Integer.parseInt(el);

                if (!result.contains(elI)) {
                    result.add(elI);
                    break;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void sortStack(Stack<String> stack, Stack<String> temp, String item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        while (!stack.isEmpty() && stack.peek().length() < item.length()) {
            temp.push(stack.pop());
        }

        stack.push(item);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    /**
     * Set 은 중복값이 들어올 수 없기 때문에 add(el) 호출 시 리턴하는 boolean 값으로 문제를 푸는 코드임
     *
     * tip)
     *  String 배열에서, length() 값을 이용해 정렬하는 방법 line 68 ~ 71
     *
     */
    public static int[] solution2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.substring(2, s.length() - 2).split("},\\{");

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });

        // Arrays.sort(arr, Comparator.comparingInt(String::length));

        int[] answer = new int[arr.length];
        int idx = 0;

        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                }
            }
        }

        return answer;
    }
}
