package programmers.level2.메뉴리뉴얼;

import java.util.*;

/**
 * 다른 사람의 풀이 중, 나온 조합 함수
 */
public class Test {
    Map<String, Integer> courseMap = new HashMap<>();
    List<String> answerList = new ArrayList<>();

    public void combination(char[] order, int start, int r, boolean[] visited) {
        if (r == 0) {
            addCourse(order, visited);
            return;
        }

        for (int i = start; i < order.length; i++) {
            visited[i] = true;
            combination(order, i + 1, r - 1, visited);
            visited[i] = false;
        }
    }

    public void addCourse(char[] order, boolean[] visited) {
        String course = "";
        for (int i = 0; i < order.length; i++) {
            if (visited[i]) {
                course += order[i];
            }
        }
        courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);
    }
}
