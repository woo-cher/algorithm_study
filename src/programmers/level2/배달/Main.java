package programmers.level2.배달;

import java.util.*;

public class Main {
    public static Set<Integer> possible = new HashSet<>();
    public static Map<Integer, List<Node>> map = new HashMap<>();
    public static int[] cost;

    public static int solution(int N, int[][] road, int K) {
        cost = new int[N + 1];
        cost[1] = 0;

        for (int i = 2; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));

        // initialize
        for (int[] r : road) {
            int v1 = r[0];
            int v2 = r[1];
            int d = r[2];

            List<Node> list = map.getOrDefault(v1, new ArrayList<>());
            list.add(new Node(v2, d));
            map.put(v1, list);

            List<Node> list2 = map.getOrDefault(v2, new ArrayList<>());
            list2.add(new Node(v1, d));
            map.put(v2, list2);
        }

        // bfs
        bfs(queue, K);

        return possible.size();
    }
    
    public static void bfs(Queue<Node> queue, int K) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.d <= K) {
                possible.add(node.village);
            }

            if (node.d > K) {
                continue;
            }

            if (map.containsKey(node.village)) {
                List<Node> pathList = map.get(node.village);

                for (Node path : pathList) {
                    int nextCost = node.d + path.d;

                    if (cost[path.village] > nextCost) {
                        Node nextNode = new Node(path.village, nextCost);
                        queue.add(nextNode);

                        cost[path.village] = nextCost;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
        int K = 3;

        System.out.println(solution(N, road, K));
    }
}

class Node {
    public int village;
    public int d;

    public Node(int n, int d) {
        this.village = n;
        this.d = d;
    }
}
