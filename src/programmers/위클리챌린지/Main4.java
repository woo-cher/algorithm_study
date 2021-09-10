package programmers.위클리챌린지;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 4주차
public class Main4 {
    public static Map<String, List<String>> map = new HashMap<>();

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int matcher = Integer.MIN_VALUE;

        for (String score : table) {
            String[] data = score.split(" ");
            map.put(data[0], Arrays.asList(data[1], data[2], data[3], data[4], data[5]));
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            int actual = 0;
            String key = entry.getKey();
            List<String> scores = entry.getValue();

            for (int i = 0; i < languages.length; i++) {
                String lan = languages[i];
                int pre = preference[i];
                int mul = scores.contains(lan) ? Math.abs(scores.indexOf(lan) - 5) : 0;

                actual += (pre * mul);
            }

            if (matcher < actual) {
                answer = key;
                matcher = actual;
            } else if (matcher == actual) {
                answer = answer.compareTo(key) < 0 ? answer : key;
                matcher = actual;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] lan = {"PYTHON", "C++", "SQL"};
        int[] per = {7, 5, 5};

        System.out.println(solution(table, lan, per));
//        String s1 = "C";
//        String s2 = "BBB";

//        System.out.println(s1.compareTo(s2));
    }
}
