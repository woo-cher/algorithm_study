package programmers.level2.메뉴리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

public class Fail {
    public static void main(String[] args) {
        String[] strs = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] strs2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] strs3 = {"XYZ", "XWY", "WXA"};

        int[] course = {2, 3, 4};
        int[] course2 = {2, 3, 5};

//        String[] answer = solution(strs, course);
        String[] answer2 = solution(strs2, course2);
//        String[] answer3 = solution(strs3, course);

        System.out.println("d");
    }

    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = setupCombination(orders, course);
        PriorityQueue<String> answer = new PriorityQueue<>();

        for (String combi : set) {
            map.put(combi, 0);
            String[] split = combi.split("");

            for (String order : orders) {
                boolean isContain = true;

                for (String menu : split) {
                    if (!order.contains(menu)) {
                        isContain = false;
                        break;
                    }
                }

                if (isContain) {
                    map.put(combi, map.get(combi) + 1);
                }
            }
        }

        for (int count : course) {
            Map.Entry<Integer, List<String>> entry = set.stream()
                    .filter(i -> i.length() == count)
                    .filter(i -> map.get(i) != 1)
                    .collect(Collectors.groupingBy(map::get, TreeMap::new, Collectors.toList()))
                    .lastEntry();

            if (entry != null) {
                answer.addAll(entry.getValue());
            }
        }

        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }

    public static Set<String> setupCombination(String[] orders, int[] course) {
        Set<String> set = new HashSet<>();
        StringBuffer buffer = new StringBuffer();

        for (int count : course) {
            for (String order : orders) {
                boolean[] visited = new boolean[orders[0].length()];
                permutation(buffer, set, order, visited, count, 0);
            }
        }

        return set;
    }

    public static void permutation(StringBuffer buffer, Set<String> set, String order, boolean[] visited, int count, int depth) {
        if (depth == count) {
            String[] strs = buffer.toString().split("");
            String sorted = Arrays.stream(strs).sorted().collect(Collectors.joining());
            set.add(sorted);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                String el = String.valueOf(order.charAt(i));
                buffer.replace(depth, depth + 1, el);
                permutation(buffer, set, order, visited, count, depth + 1);
                visited[i] = false;
            }
        }
    }
}
