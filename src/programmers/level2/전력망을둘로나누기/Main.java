package programmers.level2.전력망을둘로나누기;

import java.util.*;

class Main {
    public static Map<Integer, List<Integer>> edgeMap = new HashMap();

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            List<Integer> list = edgeMap.getOrDefault(wires[i][0], new ArrayList<>());
            list.add(wires[i][1]);
            edgeMap.put(wires[i][0], list);

            list = edgeMap.getOrDefault(wires[i][1], new ArrayList<>());
            list.add(wires[i][0]);
            edgeMap.put(wires[i][1], list);
        }

        for (int p = 0; p < wires.length; p++) {
            // init
            Exclude e = new Exclude(wires[p][0], wires[p][1]);
            int diff = bfs(new boolean[n + 1], wires[p][0], e) - bfs(new boolean[n + 1], wires[p][1], e);
            answer = Math.min(answer, Math.abs(diff));
        }

        return answer;
    }

    public static int bfs(boolean visit[], int root, Exclude exclude) {
        int edge = 0;

        Queue<Integer> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            visit[num] = true;

            if (!edgeMap.containsKey(num)) {
                continue;
            }

            for (int v : edgeMap.get(num)) {
                if (num == exclude.v1 && v == exclude.v2) { // 자른 간선이면
                    continue;
                }

                if (num == exclude.v2 && v == exclude.v1) {
                    continue;
                }

                if (visit[v]) {
                    continue;
                }

                queue.add(v);
                edge++;
            }
        }

        return edge + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        edgeMap.clear();
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        edgeMap.clear();
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}

class Exclude {
    int v1;
    int v2;

    Exclude(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}
