package programmers.level1.문자열py개수;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(sub2("PpoooyY"));
    }

    /**
     * First solution (Time average : 3 ms)
     */
    public static boolean sub(String s) {
        boolean answer = true;

        Map<String, Long> charMap = Stream.of(s.split(""))
                .map(str -> str.toLowerCase())
                .filter(str -> str.contains("p") || str.contains("y"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (charMap.get("p") != charMap.get("y")) {
            answer = false;
        }

        return answer;
    }

    /**
     *  Second Solution (Time average : 1.5 ms)
     */
    public static boolean sub2(String s) {
        boolean answer = true;
        int bitMark = 0;

        s = s.toLowerCase();
        for(String str : s.split("")) {
            if(str.equals("p")) {
                bitMark++;
            }
            if(str.equals("y")) {
                bitMark--;
            }
        }

        if(bitMark != 0) {
            answer = false;
        }

        return answer;
    }
}
