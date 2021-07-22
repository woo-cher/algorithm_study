package programmers.level2.거리두기확인하기;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Fail {
    public static void main(String[] args) {
        String[][] s = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] ans = solution(s);

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(String[][] places) {
        List<String> concated = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) {
            StringBuilder str = new StringBuilder();
            for (String el : place) {
                str.append(el);
            }

            concated.add(str.toString());
        }

        for (String actual : concated) {
            int idx = 0;
            boolean isInvalid = false;

            while (idx < actual.length()) {
                char c = actual.charAt(idx);

                if (c == 'P') {
                    if (isInvalid(actual, idx)) {
                        isInvalid = true;
                        break;
                    }
                }

                idx++;
            }

            if (isInvalid) {
                answer.add(0);
            } else {
                answer.add(1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static boolean isInvalid(String actual, int idx) {
        Direction custom = new Direction(idx);

        for (KeyValue kv : custom.getDirections(actual.length())) {
            if (actual.charAt(kv.value) == 'P') {

                if (kv.name.startsWith("top")) {
                    if (kv.name.endsWith("Right")) {
                        return actual.charAt(custom.right) == 'O' || actual.charAt(custom.up) == 'O';
                    }

                    return actual.charAt(custom.left) == 'O' || actual.charAt(custom.up) == 'O';
                }

                if (kv.name.startsWith("down")) {
                    if (kv.name.endsWith("Right")) {
                        return actual.charAt(custom.right) == 'O' || actual.charAt(custom.down) == 'O';
                    }

                    return actual.charAt(custom.left) == 'O' || actual.charAt(custom.down) == 'O';
                }

                if (kv.name.equals("dbDown")) {
                    return actual.charAt(custom.down) == 'O';
                }

                if (kv.name.equals("dbUp")) {
                    return actual.charAt(custom.up) == 'O';
                }

                if (kv.name.equals("dbRight")) {
                    return actual.charAt(custom.right) == 'O';
                }

                if (kv.name.equals("dbLeft")) {
                    return actual.charAt(custom.left) == 'O';
                }

                return true;
            }
        }

        return false;
    }
}

class Direction {
    int up;
    int down;
    int right;
    int left;
    int topRight;
    int topLeft;
    int downRight;
    int downLeft;
    int dbUp;
    int dbDown;
    int dbRight;
    int dbLeft;

    Direction(int now) {
        this.up = now - 5;
        this.down = now + 5;

        if (now % 5 != 0) {
            this.topLeft = now - 6;
            this.left = now - 1;
            this.downLeft = now + 4;
        }

        if ((now + 1) % 5 != 0) {
            this.right = now + 1;
            this.downRight = now + 6;
            this.topRight = now - 4;
        }

        if ((now - 1) % 5 != 0) {
            this.dbLeft = now - 2;
        }

        if ((now + 2) % 5 != 0) {
            this.dbRight = now + 2;
        }

        this.dbUp = now - 10;
        this.dbDown = now + 10;
    }

    public List<KeyValue> getDirections(int size) {
        List<KeyValue> list = new ArrayList<>();

        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            int value = 0;

            try {
                value = (int) f.get(this);

                if (value > 0 && value < size) {
                    list.add(new KeyValue(f.getName(), (int) f.get(this)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}

class KeyValue {
    String name;
    int value;

    public KeyValue(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
