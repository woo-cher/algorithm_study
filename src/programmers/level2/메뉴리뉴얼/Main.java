package programmers.level2.메뉴리뉴얼;

import java.util.*;

public class Main {
    private static List<Map<String, Integer>> maps = new ArrayList<>();
    private static int[] maxCnt = new int[11];

    public static void main(String[] args) {
        String[] strs = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] strs2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] strs3 = {"XYZ", "XWY", "WXA"};

        int[] course = {2, 3, 4};
        int[] course2 = {2, 3, 5};

//        String[] answer = solution(strs, course);
        String[] answer2 = solution(strs2, course2);
//        String[] answer3 = solution(strs3, course);
    }

    public static void comb(char[] str, int depth, StringBuilder builder) {
        if (depth >= str.length) {
            int len = builder.length();

            if (len >= 2) {
                   int cnt = maps.get(len).getOrDefault(builder.toString(), 0) + 1;
                   maps.get(len).put(builder.toString(), cnt);
                   maxCnt[len] = Math.max(maxCnt[len], cnt);
            }

            return;
        }

        comb(str, depth + 1, builder.append(str[depth]));
        builder.setLength(builder.length() - 1);
        comb(str, depth + 1, builder);
    }

    public static String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < 11; i++) {
            maps.add(new HashMap<>());
        }

        for (String str : orders) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for (int len : course) {
            for (Map.Entry<String, Integer> entry : maps.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == maxCnt[len]) {
                    list.add(entry.getKey());
                }
            }
        }

        return list.stream().sorted().toArray(String[]::new);
    }
}
