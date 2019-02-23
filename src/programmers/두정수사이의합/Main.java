package programmers.두정수사이의합;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(sub2(3, 5));
    }

    // First Solution
    public static long sub(int a, int b) {
        if (a == b) {
            return a;
        }

        int[] arr = {0, 0};
        arr[0] = a;
        arr[1] = b;

        Arrays.sort(arr);

        long sum = 0;
        for (int i = arr[0]; i < arr[1] + 1; i++) {
            sum += (long)i;
        }
        return sum;
    }

    // Second Solution
    public static long sub2(int a, int b) {
        long sum = 0;
        for (int i = (a > b ? b : a); i <= (a > b ? a : b); i++) {
            sum += i;
        }
        return sum;
    }
}