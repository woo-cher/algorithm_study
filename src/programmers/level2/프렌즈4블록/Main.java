package programmers.level2.프렌즈4블록;

import java.util.*;

class Main {
    public static Set<Coord> sets = new HashSet<>();
    public static int[] dx = {0, 0, 1, 1};
    public static int[] dy = {0, 1, 1, 0};
    public static String[][] map;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new String[m][n];

        // initilize
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }

        while (true) {
            // loop & dfs
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String kf = map[i][j];

                    if (kf.isEmpty()) {
                        continue;
                    }

                    List<Coord> list = new ArrayList();
                    dfs(kf, i, j, list);
                }
            }

            if (sets.size() == 0) {
                break;
            }

            // delete
            for (Coord el : sets) {
                map[el.x][el.y] = "";
                answer++;
            }

            sets.clear();

            // refresh
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    String kf = map[j][i];

                    if (!kf.isEmpty()) {
                        continue;
                    }

                    if (!canSwap(j, i)) {
                        continue;
                    }

                    swap(j, i);
                }
            }
        }

        return answer;
    }

    public static boolean canSwap(int x, int y) {
        if (x == 0) {
            return false;
        }

        for (int i = x - 1; i >= 0; i--) {
            if (!map[i][y].isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public static void swap(int x, int y) {
        // Search first empty block
        for (int i = x - 1; i >= 0; i--) {
            String block = map[i][y];

            if (!block.isEmpty()) {
                map[x][y] = block;
                map[i][y] = "";
                return;
            }
        }
    }

    public static void dfs(String kf, int x, int y, List<Coord> list) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            boolean abe = nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length;

            if (abe || !map[nx][ny].equals(kf)) {
                return;
            }

            list.add(new Coord(nx, ny));
        }

        if (list.size() == 4) {
            sets.addAll(list);
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
//        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
//        System.out.println(solution(4, 5, new String[]{"AAAAA", "AUUUA", "AUUAA", "AAAAA"}));
//        System.out.println(solution(6, 6, new String[]{"IIIIOO", "IIIOOO", "IIIOOI", "IOOIII", "OOOIII", "OOIIII"}));
        System.out.println(solution(6, 2, new String[]{"DD", "CC", "AA", "AA", "CC", "DD"}));
        System.out.println(solution(8, 2, new String[]{"FF", "AA", "CC", "AA", "AA", "CC", "DD", "FF"}));
        System.out.println(solution(6, 2, new String[]{"AA", "AA", "CC", "AA", "AA", "DD"}));
    }
}

class Coord {
    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
