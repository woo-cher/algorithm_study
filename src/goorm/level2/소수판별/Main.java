package goorm.level2.소수판별;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);
        String answer = "True";

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                answer = "False";
                break;
            }
        }

        System.out.print(answer);
    }
}
