package goorm.level1.고장난컴퓨터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();

        String[] data = input.split(" ");
        int[] times = Arrays.stream(input2.split(" ")).mapToInt(Integer::parseInt).toArray();
//        String[] data = new String[]{"6", "5"};
//        int[] times = new int[]{1, 3, 8, 14, 19, 20};

        int answer = 0; // 모니터 글자 수
        int limit = Integer.parseInt(data[1]); // 입력 유지 시간
        int prev = 0;
        int during;

        for (int n : times) {
            during = n - prev;

            // 유지 시간을 초과한 경우
            if (during >= limit + 1) {
                answer = 0;
                during = 0;
            }

            prev = n;
            answer++;
        }

        System.out.println(answer);
    }
}
