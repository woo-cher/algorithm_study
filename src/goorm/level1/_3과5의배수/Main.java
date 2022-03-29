package goorm.level1._3과5의배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);
        int sum = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 3; i <= n; i += 3) {
            set.add(i);
        }

        for (int i = 5; i <= n; i += 5) {
            set.add(i);
        }

        sum = set.stream().mapToInt(i -> i).sum();
        System.out.print(sum);
    }
}
