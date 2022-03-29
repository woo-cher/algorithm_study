package goorm.level2.빙글빙글1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  배열에서 찍는 방향 전환 로직을 -1 을 곱하여 구현한 방법
 */
public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);
        String[][] data = new String[n][n];

        for (String[] strs : data) {
            Arrays.fill(strs, " ");
        }

        int i = 0, j = -1;
        int s = 1;

        for (int p = 0; p < n; p++) {
            j += s;
            data[i][j] = "#";
        }

        n--;

        while (n > 0) {
            for (int p = 0; p < n; p++) {
                i += s;
                data[i][j] = "#";
            }

            s *= -1; // 방향 전환

            for (int p = 0; p < n; p++) {
                j += s;
                data[i][j] = "#";
            }

            n -= 2;
        }

        for (int p = 0; p < data.length; p++) {
            for (int q = 0; q < data[0].length; q++) {
                System.out.print(data[p][q] + " ");
            }

            System.out.println("");
        }
    }
}
