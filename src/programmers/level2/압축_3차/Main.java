package programmers.level2.압축_3차;

import java.util.*;

public class Main {
    public static int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // init
        int idx = 1;
        char c = 'A';
        while (c != 'Z' + 1) {
            map.put(String.valueOf(c++), idx++);
        }

        for (int i = 0; i < msg.length(); ) {
            String format = getFormatString(msg, i, map);
            list.add(map.get(format));

            i += format.length();
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static String getFormatString(String msg, int index, Map<String, Integer> map) {
        String s = msg.charAt(index) + "";

        while (map.containsKey(s)) {
            if (index == msg.length() - 1) {
                return s;
            }

            s += msg.charAt(++index);
        }

        map.put(s, map.size() + 1);
        return s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }
}
