package goorm.level1._369게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(6);
        set.add(9);

        for (int i = 1; i < n; i++) {
            String str = String.valueOf(i);

            if (str.contains("3") || str.contains("6") || str.contains("9")) {
                for (int j = 0; j < str.length(); j++) {
                    int num = str.charAt(j) - '0';

                    if (set.contains(num)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
