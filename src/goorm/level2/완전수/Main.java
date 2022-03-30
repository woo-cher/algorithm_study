package goorm.level2.완전수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);

        for (int i = n1; i < n2 + 1; i++) {
            if(isOk(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isOk(int n) {
        if (n == 1) {
            return false;
        }

        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum + 1 == n;
    }
}
