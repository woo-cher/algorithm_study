package programmers.level2.카카오프렌즈컬러링북;

/**
 *  1. 방문여부를 판단하는 배열 선언
 *  2. (0, 0) 을 시작점으로, 좌우상하를 파싱하면서 영역수 및 면적 파싱
 */
public class Main {
    public static void main(String[] args) {
        int[][] picture = new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        solution(6, 4, picture);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        boolean[][] visited = new boolean[picture.length][picture[0].length];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int value = picture[i][j];
                int area = 0;

                if (value == 0 || visited[i][j]) {
                    continue;
                }

                numberOfArea++;
                area = parseArea(value, i, j, picture, visited);

                if (maxSizeOfOneArea < area) {
                    maxSizeOfOneArea = area;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public static int parseArea(int prev, int x, int y, int[][] picture, boolean[][] visited) {

        /**
         * 배열 값 검사 하기 전에, 인덱스가 유효한지 판단
         */
        final boolean ARRAY_BOUND_EXCEPTION =
                x < 0 || y < 0 || x == picture.length || y == picture[0].length || picture[x][y] == 0;

        if (ARRAY_BOUND_EXCEPTION) {
            return 0;
        }

        if (visited[x][y] || prev != picture[x][y]) { // 없는 영역이거나, 다른 영역이면 0 리턴
            return 0;
        }

        // 동일 영역조건
        int area = 0;
        visited[x][y] = true;
        area++;

        area += parseArea(prev, x + 1, y, picture, visited); // right
        area += parseArea(prev, x - 1, y, picture, visited); // left
        area += parseArea(prev, x, y + 1, picture, visited); // down
        area += parseArea(prev, x, y - 1, picture, visited); // up

        return area;
    }
}
