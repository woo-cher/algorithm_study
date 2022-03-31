package goorm.level2.외계인과용돈기입장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long[] money = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // pre calculate O(n)
        for (int i = 1; i < money.length; i++) {
            money[i] = money[i - 1] + money[i];
        }

        int size = Integer.parseInt(input[1]);
        List<Long> answer = new ArrayList<>();

        int start, end;
        long sum;

        // O(m)
        for (int i = 0; i < size; i++) {
            String[] range = br.readLine().split(" ");

            start = Integer.parseInt(range[0]) - 1;
            end = Integer.parseInt(range[1]) - 1;

            sum = start != 0 ? money[end] - money[start - 1] : money[end];
            answer.add(sum);
        }

        for (long n : answer) {
            System.out.println(n >= 0 ? "+" + n : n);
        }
    }

    public static void fail(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        long[] money = Arrays.stream(br.readLine().split(" ")).mapToLong(n -> {
            if (n.startsWith("+")) {
                return Long.parseLong(n.substring(1));
            }

            return Long.parseLong(n.substring(1)) * -1;
        }).toArray();

        int size = Integer.parseInt(input[1]);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String[] range = br.readLine().split(" ");

            int start = Integer.parseInt(range[0]) - 1;
            int end = Integer.parseInt(range[1]);

            int sum = 0;
            for (int j = start; j < end; j++) {
                sum += money[j];
            }

            answer.add(sum);
        }

        for (int n : answer) {
            System.out.println(n >= 0 ? "+" + n : n);
        }
    }
}
