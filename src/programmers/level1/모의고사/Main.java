package programmers.level1.모의고사;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제가 명확하게 정의되어 있지 않다.
 * 예제 출력값이 유효하지 않다.
 * 모두 0개 맞추면 1,2,3 출력
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = sub(new int[]{1,3,1,4,2});
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // Brute-force
    public static int[] sub(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] score = new int[3];
        String[] str = {"12345", "21232425", "3311224455"};

        for (int i = 0; i < str.length; i++) {
            int strIndex = 0;
            for (int j = 0; j < answers.length; j++) {
                if (strIndex == str[i].length()) {
                    strIndex = 0;
                }
                if (str[i].charAt(strIndex) - '0' == answers[j]) {
                    score[i]++;
                }
                strIndex++;
            }
        }

        // Get Max Value
        int max = getMax(score[0], getMax(score[1], score[2]));

        // Get answer
        for(int k = 0; k < score.length; k++) {
            if(max == score[k]) {
                answer.add(k);
            }
        }

        // Convert List -> int[]
        return answer.stream().mapToInt(i -> i + 1).toArray();
    }

    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }
}
