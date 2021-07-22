package programmers.level2.거리두기확인하기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fail2 {
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

    public static int[] solution(String[][] places) {
        boolean[][] visited = new boolean[places.length][places[0].length];
        Queue<Node> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        List<Node> logs = new ArrayList<>();

        int i = 0;
        for (String[] place : places) {
            int j = 0;
            for (String room : place) { // 방 하나씩 검사
                int k = 0;

                while (k < room.length()) {
                    if (room.charAt(k) == 'P') {
                        visited[j][k] = true;
                        Node baseNode = new Node(j, k, 0);

                        queue.offer(baseNode);

                        while (!queue.isEmpty()) {
                            Node node = queue.poll();
                            logs.add(node);

                            if (node.distance == 1) {
                                if (place[node.x].charAt(node.y) == 'P') {
                                    answer.add(0);
                                    break;
                                }
                            }

                            if (node.distance == 2) {
                                if (place[node.x].charAt(node.y) == 'P') {
                                    if (isInvalid(node, baseNode, place)) {
                                        answer.add(0);
                                        break;
                                    }
                                }

                                continue;
                            }

                            for (int n = 0; n < dx.length; n++) {
                                int x = node.x + dx[n];
                                int y = node.y + dy[n];

                                boolean ARRAY_BOUND_EXCEPTION = x < 0 || y < 0 || x == places.length || y == places[0].length;

                                if (!ARRAY_BOUND_EXCEPTION && !visited[x][y]) {
                                    visited[x][y] = true;
                                    queue.add(new Node(x, y, getDistance(baseNode.x, baseNode.y, x, y)));
                                }
                            }
                        }
                    }

                    if (answer.size() == i + 1) {
                        break;
                    }

                    k++;
                }

                if (!logs.isEmpty()) {
                    for (Node n : logs) {
                        visited[n.x][n.y] = false;
                    }
                    logs.clear();
                }

                if (answer.size() == i + 1) {
                    break;
                }

                j++;
            }

            if (answer.size() != i + 1) {
                answer.add(1);
            }

            i++;
        }

        return answer.stream().mapToInt(n -> n).toArray();
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static boolean isInvalid(Node actual, Node matcher, String[] place) {
        int x = matcher.x;
        int y = matcher.y;

        if (actual.x == x) { // row
            return actual.y < y ? place[x].charAt(y - 1) == 'O' : place[x].charAt(y + 1) == 'O';
        } else if (actual.y == y) { // col
            return actual.x < x ? place[x - 1].charAt(y) == 'O' : place[x + 1].charAt(y) == 'O';
        } else if (actual.x < x && actual.y < y) { // Top Left
            return place[x - 1].charAt(y) == 'O' || place[actual.x].charAt(y - 1) == 'O';
        } else if (actual.x > x && actual.y > y) { // Bottom Right
            return place[x + 1].charAt(y) == 'O' || place[x].charAt(y + 1) == 'O';
        } else if (actual.x < x) { // Top Right
            return place[x - 1].charAt(y) == 'O' || place[x].charAt(y + 1) == 'O';
        } else { // Bottom left
            return place[x + 1].charAt(y) == 'O' || place[x].charAt(y - 1) == 'O';
        }
    }
}

class Node {
    public int x;
    public int y;
    public int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
