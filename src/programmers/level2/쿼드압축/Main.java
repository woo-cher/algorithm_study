package programmers.level2.쿼드압축;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;

        Queue<S> queue = new LinkedList();
        queue.offer(new S(0, 0, n));

        while (!queue.isEmpty()) {
            S s = queue.poll();
            int result = parse(arr, queue, s);

            if (result == -1) {
                continue;
            }

            answer[result]++;
        }

        return answer;
    }

    public static int parse(int[][] arr, Queue<S> queue, S s) {
        int limit = s.n;
        int zero = 0;
        int one = 0;

        for (int i = 0; i < limit; i++) {
            int x = i + s.x;
            for (int j = 0; j < limit; j++) {
                int y = j + s.y;

                if (arr[x][y] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        if (zero == limit * limit) { // is all zero?
            return 0;
        } else if (one == limit * limit) { // is all one?
            return 1;
        } else { // compress fail
            limit /= 2;

            queue.add(new S(s.x, s.y, limit));
            queue.add(new S(s.x, s.y + limit, limit));
            queue.add(new S(s.x + limit, s.y, limit));
            queue.add(new S(s.x + limit, s.y + limit, limit));

            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }
}

class Index {
    int x;
    int y;

    Index(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class S extends Index {
    int n;

    S(int x, int y, int n) {
        super(x, y);
        this.n = n;
    }
}
