package programmers.level2.거리두기확인하기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        String[][] s = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
        };

        int[] ans = solution(s);

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    private static int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < places.length; i++) {
            for (int x = 0; x < places[0].length && answer.size() != i + 1; x++) {
                for (int y = 0; y < places[i][x].length() && answer.size() != i + 1; y++) {
                    if (places[i][x].charAt(y) == 'P') {
                        if (!bfs(x, y, places[i])) {
                            answer.add(0);
                            break;
                        }
                    }
                }
            }

            if (answer.size() != i + 1) {
                answer.add(1);
            }
        }

        return answer.stream().mapToInt(n -> n).toArray();
    }

    public static boolean bfs(int x, int y, String[] place) {
        boolean[][] visited = new boolean[place.length][place[0].length()];
        Queue<Spot> queue = new LinkedList<>();

        queue.offer(new Spot(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Spot s = queue.poll();

            if (s.distance == 2) {
                continue;
            }

            for (int n = 0; n < dx.length; n++) {
                int newX = s.x + dx[n];
                int newY = s.y + dy[n];
                boolean ARRAY_BOUND_EXCEPTION = newX < 0 || newY < 0 || newX == place.length || newY == place[0].length();

                if (!ARRAY_BOUND_EXCEPTION && !visited[newX][newY]) {
                    if (place[newX].charAt(newY) == 'P') {
                        return false;
                    } else if (place[newX].charAt(newY) == 'O') {
                        visited[newX][newY] = true;
                        queue.add(new Spot(newX, newY, getDistance(x, y, newX, newY)));
                    }
                }
            }
        }

        return true;
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

class Spot {
    public int x;
    public int y;
    public int distance;

    public Spot(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
