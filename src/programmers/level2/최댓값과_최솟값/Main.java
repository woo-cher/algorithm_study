package programmers.level2.최댓값과_최솟값;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static String solution(String s) {
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> min = new PriorityQueue<>();

        for (String str : s.split(" ")) {
            int n = Integer.parseInt(str);
            max.add(n);
            min.add(n);
        }

        return String.format("%s %s", min.poll(), max.poll());
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }
}
