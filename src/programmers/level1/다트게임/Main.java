package programmers.level1.다트게임;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("1D2S3T*"));
//        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        Map<String, Integer> scoreTable = new HashMap<>();

        scoreTable.put("S", 1);
        scoreTable.put("D", 2);
        scoreTable.put("T", 3);

        int[] scores = {0, 0, 0};
        int answer = 0;
        int round = 0;
        String els = "";

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            els += String.valueOf(c);

            if (!Character.isDigit(c)) {
                if (i == dartResult.length() - 1) {

                } else if (!Character.isDigit(dartResult.charAt(i + 1))) {
                    continue;
                }

                int num = Integer.parseInt(els.replaceAll("[S|D|T|#|*]", ""));
                int bonus = scoreTable.get(els.replaceAll("[0-9|#|*]", ""));
                int calculated = (int) Math.pow(num, bonus);

                scores[round] += calculated;

                String prize = els.replaceAll("[0-9|S|D|T]", "");
                scoreTable.get(prize);

                if (prize.equals("*")) {
                    scores[round] *= 2;
                    if (round != 0) {
                        scores[round - 1] *= 2;
                    }
                } else if (prize.equals("#")) {
                    scores[round] *= -1;
                }

                els = "";
                round++;
            }
        }

        for (int s : scores) {
            answer += s;
        }

        return answer;
    }
}
