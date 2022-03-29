package goorm.level2.빙글빙글1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  네 방향에 대한 로직을 개별로 모두 구현했으므로 비효율적
 */
public class Main {
    public static String[] mode = {"RIGHT", "DOWN", "LEFT", "UP"};
    public static int start = 0;
    public static int fix = 0;
    public static int shop;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        shop = Integer.parseInt(input);

        String[][] arr = new String[shop][shop * 2];

        for (String[] sArr : arr) {
            Arrays.fill(sArr, " ");
        }

        // 첫째줄
        right(arr, shop--);

        int idx = 1;
        int changed = 0;
        while (shop != 0) {
            if (changed != 0 && changed % 2 == 0) {
                shop -= 2;
            }

            switch (mode[idx]) {
                case "RIGHT" -> right(arr, shop);
                case "DOWN" -> down(arr, shop);
                case "LEFT" -> left(arr, shop);
                case "UP" -> up(arr, shop);
            }

            idx = idx + 1 == 4 ? 0 : idx + 1;
            changed++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }

            System.out.println("");
        }
    }

    public static void right(String[][] map, int cnt) {
        while (cnt != 0) {
            map[fix][start] = "#";
            start += 2;
            cnt--;
        }

        int tmp = start - 2;
        start = fix + 1;
        fix = tmp;
    }

    public static void down(String[][] map, int cnt) {
        while (cnt != 0) {
            map[start][fix] = "#";
            start++;
            cnt--;
        }

        int tmp = start - 1;
        start = (tmp * 2) - 2;
        fix = tmp;
    }

    public static void left(String[][] map, int cnt) {
        while (cnt != 0) {
            map[fix][start] = "#";
            start -= 2;
            cnt--;
        }

        int tmp = start + 2;
        start = fix - 1;
        fix = tmp;
    }

    public static void up(String[][] map, int cnt) {
        while (cnt != 0) {
            map[start][fix] = "#";
            start--;
            cnt--;
        }

        int tmp = start + 1;
        start = fix + 2;
        fix = tmp;
    }
}
