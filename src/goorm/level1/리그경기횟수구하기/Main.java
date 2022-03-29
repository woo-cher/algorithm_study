package goorm.level1.리그경기횟수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        int answer = 0;
        for (int i = 1; i < n; i++) {
            answer += i;
        }

        System.out.print(answer);
    }
}
