package programmers.level1.소수찾기;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(100000));
    }

    public static int solution(int n) {
        List<Integer> checkList = new ArrayList<>();
        int count = 0;

        checkList.add(0);
        checkList.add(0);

        for (int i = 2; i < n + 1; i++) {
            checkList.add(1);
        }

        for (int i = 2; i * i <= n; i++) {
            if (checkList.get(i) == 1) {
                for (int j = i * i; j <= n; j += i) {
                    checkList.set(j, 0);
                }
            }
        }

        for (int bool : checkList) {
            if(bool == 1) {
                count++;
            }
        }

        return count;
    }
}
