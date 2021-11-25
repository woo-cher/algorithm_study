package programmers.level2.방문길이;

import java.util.*;

class Main {
    public static final int LIMIT = 5;

    public static int solution(String dirs) {
        int answer = 0;
        Map<Coord, Set<Coord>> map = new HashMap<>();

        Coord now = new Coord(0, 0);
        map.put(now, new HashSet<>());

        for (int i = 0; i < dirs.length(); i++) {
            String dir = dirs.charAt(i) + "";
            Coord after = move(now, dir);

            if (now.equals(after)) {
                continue;
            }

            answer++;

            // validate
            Set<Coord> paths = map.getOrDefault(after, new HashSet<>());

            if (!paths.isEmpty()) {
                if (paths.contains(now)) {
                    answer--;
                    now = after;
                    continue;
                }
            }

            // put
            Set<Coord> set = map.getOrDefault(now, new HashSet<>());
            set.add(after);
            map.put(now, set);

            set = map.getOrDefault(after, new HashSet<>());
            set.add(now);
            map.put(after, set);

            now = after;
        }

        return answer;
    }

    public static Coord move(Coord now, String mark) {
        int x = now.x;
        int y = now.y;

        switch(mark) {
            case "U" -> y++;
            case "D" -> y--;
            case "L" -> x--;
            case "R" -> x++;
        }

        if (Math.abs(x) > LIMIT || Math.abs(y) > LIMIT) {
            return now;
        }

        return new Coord(x, y);
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDUDULRRLUDUU"));
        System.out.println(solution("UDU"));
    }
}

class Coord {
    int x;
    int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
