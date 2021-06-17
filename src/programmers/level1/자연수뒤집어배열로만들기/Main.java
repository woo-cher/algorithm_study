package programmers.level1.자연수뒤집어배열로만들기;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] solution(long n) {
        List<Integer> nList = new ArrayList<>();
        String str = String.valueOf(n);

        StringBuilder builder = new StringBuilder(str);
        str = builder.reverse().toString();

        for (int i = 0; i < str.length(); i++) {
            nList.add(str.charAt(i) - '0');
        }

        return nList.stream().mapToInt(num -> num).toArray();
    }
}
