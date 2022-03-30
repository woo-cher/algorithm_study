package goorm.level1.의좋은형제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();

        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int day = Integer.parseInt(input2);

        int give = 0;
        int take = 1;

        for (int i = 1; i <= day; i++) {
            int divide = Math.round((float) arr[give] / 2);

            arr[give] -= divide;
            arr[take] += divide;

            give = give == 1 ? 0 : 1;
            take = take == 1 ? 0 : 1;
        }

        System.out.println(arr[0] + " " + arr[1]);
    }
}
