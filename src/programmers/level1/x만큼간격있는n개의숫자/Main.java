package programmers.level1.x만큼간격있는n개의숫자;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        long num = 0;

        while (true) {
            if (list.size() == n) {
                break;
            }

            num += x;
            list.add(num);
        }

        return list.stream()
                .mapToLong(i -> i)
                .toArray();
    }
}
