package programmers.level2.후보키;

import java.util.*;

public class Main {
    public static List<String> comb = new ArrayList<>();
    public static List<Set<String>> sets = new ArrayList<>();

    public static int solution(String[][] relation) {
        int answer = 0;

        String[] columns = new String[relation[0].length];

        for (int i = 0; i < relation[0].length; i++) {
            columns[i] = String.valueOf(i);
        }

        for (int r = 1; r < columns.length + 1; r++) {
            combination(columns, new boolean[columns.length], 0, r);
        }

        for (int i = 0; i < comb.size(); i++) {
            sets.add(new HashSet<>());
        }

        for (String[] row : relation) {
            for (int i = 0; i < comb.size(); i++) {
                String combination = comb.get(i);
                String entry = getEntry(row, combination);
                sets.get(i).add(entry);
            }
        }

        int rows = relation.length;
        for (int i = 0; i < comb.size(); ) {
            if (sets.get(i).size() == rows) {
                answer++;
                String tuple = comb.get(i);
                remove(tuple);
                continue;
            }

            i++;
        }

        return answer;
    }

    public static void combination(String[] input, boolean[] visited, int start, int r) {
        if (r == 0) {
            String s = "";
            for (int i = 0; i < input.length; i++) {
                if (visited[i]) {
                    s += input[i];
                }
            }

            comb.add(s);
        }

        for (int i = start; i < input.length; i++) {
            visited[i] = true;
            combination(input, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void remove(String tuple) {
        String[] el = tuple.split("");

        for (int i = 0; i < comb.size(); ) {
            boolean isContainAll = true;
            String matcher = comb.get(i);

            for (String actual : el) {
                if (!matcher.contains(actual)) {
                    isContainAll = false;
                    break;
                }
            }

            if (isContainAll) {
                comb.remove(i);
                sets.remove(i);
                continue;
            }

            i++;
        }
    }

    public static String getEntry(String[] row, String combination) {
        String result = "";

        for (String idx : combination.split("")) {
            int i = Integer.parseInt(idx);
            result += row[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };

        String[][] input2 = {
                {"a", "1", "aaa", "c", "ng"},
                {"b", "1", "bbb", "c", "g"},
                {"c", "1", "aaa", "d", "ng"},
                {"d", "2", "bbb", "d", "ng"}
        };

        System.out.println(solution(input));
        System.out.println(solution(input2));
    }
}
