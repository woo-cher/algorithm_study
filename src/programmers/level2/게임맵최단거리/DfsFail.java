package programmers.level2.게임맵최단거리;

import java.util.ArrayList;
import java.util.List;

/**
 * Dfs 의 경우 모든 노드를 탐색하기 때문에
 * 케이스 규모가 커짐에 따라,
 * 과도한 재귀 호출 및 불필요한 탐색으로 시간초과 발생
 *
 * 효율성 테스트)
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 */
public class DfsFail {
    public static void main(String[] args) {
        int[][] maps = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        List<Integer> costs = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        dfs(0, 0, 1, costs, maps, visited);

        if (costs.size() == 0) {
            return -1;
        }

        return costs.stream()
                .mapToInt(i -> i)
                .min()
                .getAsInt();
    }

    public static void dfs(int x, int y, int move, List<Integer> costs, int[][] maps, boolean[][] visited) {
        final boolean ARRAY_BOUND_EXCEPTION = x < 0 || y < 0 || x == maps.length || y == maps[0].length;

        if (x == maps.length - 1 && y == maps[0].length - 1) {
            costs.add(move);
            return;
        }

        if (ARRAY_BOUND_EXCEPTION) {
            return;
        }

        if (maps[x][y] == 0 || visited[x][y]) { // Is wall or visited?
            return;
        }

        visited[x][y] = true;

        dfs(x, y + 1, move + 1, costs, maps, visited); // right
        dfs(x, y - 1, move + 1, costs, maps, visited); // left
        dfs(x + 1, y, move + 1, costs, maps, visited); // down
        dfs(x - 1, y, move + 1, costs, maps, visited); // up

        visited[x][y] = false;
    }
}
