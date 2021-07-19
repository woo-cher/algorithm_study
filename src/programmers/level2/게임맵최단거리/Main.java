package programmers.level2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

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
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node position = queue.poll();
            int x = position.getX();
            int y = position.getY();
            int cost = position.getCost();

            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = Math.min(answer, position.getCost() + 1);
                continue;
            }

            bfs(x, y + 1, cost + 1, queue, maps, visited); // right
            bfs(x, y - 1, cost + 1, queue, maps, visited); // left
            bfs(x + 1, y, cost + 1, queue, maps, visited); // down
            bfs(x - 1, y, cost + 1, queue, maps, visited); // up
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void bfs(int x, int y, int cost, Queue<Node> queue, int[][] maps, boolean[][] visited) {
        boolean ARRAY_BOUND_EXCEPTION = x < 0 || y < 0 || x == maps.length || y == maps[0].length;

        if (ARRAY_BOUND_EXCEPTION) {
            return;
        }

        if (maps[x][y] == 0 || visited[x][y]) { // Is wall or visited?
            return;
        }

        queue.add(new Node(x, y, cost));
        visited[x][y] = true;
    }
}

class Node {
    private int x;
    private int y;
    private int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return cost;
    }
}
