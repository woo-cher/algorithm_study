package programmers.level2.두개이하로다른비트;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        int i = 0;
        for (long number : numbers) {
            answer[i++] = number % 2 == 0 ? number + 1 : findMinimum(number);
        }

        return answer;
    }

    /**
     *  홀수인 임의의 n 에 대해서, 끝에서부터 비트 1인 개수를 찾음
     *  구한 1의 개수를 가지고, 발견한 규칙에 대한 계산식으로 리턴
     */
    public static long findMinimum(long input) {
        String s = Long.toBinaryString(input);
        long cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                break;
            }

            cnt++;
        }

        if (cnt == 1) {
            return input + 1;
        }

        return (long) (input + Math.pow(2, cnt - 1));
    }

    /**
     *  XOR 연산 결과값에 1의 비트 개수가 2개 이하면 리턴
     *  2개 테스트케이스 시간초과 발생
     */
    public static long getMinimumBit(long number) {
        long n = number + 1;
        Pattern pattern = Pattern.compile("1");

        while (true) {
            String xor = "";
            Matcher matcher = pattern.matcher(Long.toBinaryString(number ^ n));

            while (matcher.find() && xor.length() < 3) {
                xor += matcher.group();
            }

            if (xor.length() < 3) {
                break;
            }

            n++;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{31})));
    }
}
