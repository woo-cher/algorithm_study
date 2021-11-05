package programmers.위클리챌린지;

import java.util.*;

// 10주차_교점에 별 만들기
class Main10 {
    public static List<Coord> commons = new ArrayList<>();
    public static long mx, px, my, py;

    public static String[] solution(int[][] line) {
        String[] answer = {};

        mx = my = Long.MAX_VALUE;
        px = py = Long.MIN_VALUE;

        // line 에 대하여, 모든 조합을 구한 뒤 교점을 구한다
        // 행, 열의 최대 & 최소값 구한다
        for (int i = 0; i < line.length - 1; i++) {
            Equation e1 = new Equation(line[i][0], line[i][1], line[i][2]);

            for (int j = i + 1; j < line.length; j++) {
                Equation e2 = new Equation(line[j][0], line[j][1], line[j][2]);

                long adbc = e1.x * e2.y - e1.y * e2.x;
                long bfed = e1.y * e2.n - e1.n * e2.y;
                long ecaf = e1.n * e2.x - e1.x * e2.n;

                if (adbc == 0 || bfed % adbc != 0 || ecaf % adbc != 0) {
                    continue;
                }

                long x = bfed / adbc;
                long y = ecaf / adbc;

                mx = Math.min(mx, x);
                my = Math.min(my, y);
                px = Math.max(px, x);
                py = Math.max(py, y);

                commons.add(new Coord(x, y));
            }
        }

        long row = px - mx + 1;
        long col = py - my + 1;

        // 행, 열을 가지고 배열 초기화
        answer = new String[(int) col];
        Arrays.fill(answer, getStringEl((int) row));

        // 별 찍기
        for (Coord c : commons) {
            long nx = c.x - mx;
            long ny = py - c.y;

            String s = answer[(int) ny];

            s = s.substring(0, (int) nx) + "*" + s.substring((int) (nx + 1));
            answer[(int) ny] = s;
        }

        return answer;
    }

    public static String getStringEl(int size) {
        return ".".repeat(size);
    }

    public static Equation getEquation(int[][] line, int idx) {
        return new Equation(line[idx][0], line[idx][1], line[idx][2]);
    }

    public static void main(String[] args) {
        solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
//        solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}});
//        solution(new int[][]{{1, -1 ,0}, {2, -1 ,0}, {4, -1, 0}});
    }
}

class Coord {
    long x;
    long y;

    Coord(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Equation extends Coord {
    long n;

    public Equation(long x, long y, long n) {
        super(x, y);
        this.n = n;
    }
}
