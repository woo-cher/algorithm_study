package programmers.level2.구명보트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fail {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(people);

        for (int n : people) {
            list.add(n);
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); ) {
                answer += 1;
                int l = limit - list.get(i);
                list.remove(i);

                for (int j = list.size() - 1; j >= 0; j--) {
                    if (l - list.get(j) >= 0) {
                        list.remove(j);
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 5, 7, 7, 4}, 10));
//        System.out.println(solution(new int[]{50, 70, 80}, 100));
    }
}
