package programmers.위클리챌린지;

import java.util.*;

// 2주차
public class Main2 {
    public static Map<Integer, List<Integer>> map = new HashMap<>();
    public static int[] maxArr;
    public static int[] minArr;

    public static String solution(int[][] scores) {
        String answer = "";
        int size = scores.length;

        maxArr = new int[size];
        minArr = new int[size];

        Arrays.fill(maxArr, Integer.MIN_VALUE);
        Arrays.fill(minArr, Integer.MAX_VALUE);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) { // j : student's number
                int score = scores[i][j];

                if (maxArr[j] < score) {
                    maxArr[j] = score;
                }

                if (minArr[j] > score) {
                    minArr[j] = score;
                }

                List<Integer> entry = map.getOrDefault(j, new ArrayList<>());
                entry.add(score);
                map.put(j, entry);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> scoreList = entry.getValue();
            validate(entry.getKey(), scoreList);
            double average = getAverage(scoreList);
            answer += getGrade(average);
        }

        return answer;
    }

    public static double getAverage(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    public static void validate(int studentNum, List<Integer> scores) {
        int selfScore = scores.get(studentNum);

        if (selfScore == maxArr[studentNum] || selfScore == minArr[studentNum]) {
            if (scores.indexOf(selfScore) == scores.lastIndexOf(selfScore)) { // only `minimum` or `maximum` ?
                scores.remove(studentNum);
            }
        }
    }

    public static String getGrade(double avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80 && avg < 90) {
            return "B";
        } else if (avg >= 70 && avg < 80) {
            return "C";
        } else if (avg >= 50 && avg < 70) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        int[][] input = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
        System.out.println(solution(input));
    }
}
