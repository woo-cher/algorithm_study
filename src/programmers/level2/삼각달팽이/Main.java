package programmers.level2.삼각달팽이;

import java.util.Arrays;

public class Main {
    public static int[] solution(int n) {
        int blocks = getAllBlocks(n);
        int[] answer = new int[blocks];

        int cycle = 0;
        int floor = 1;
        int value = 1;

        int idx = 0;
        while (value < blocks + 1) {
            if (idx == getAllBlocks(n - cycle) - cycle) { // 삼각달팽이의 맨 아래층 작업이 끝났을 때
                idx = idx - floor - 1;

                for (; idx >= 0; idx = idx - floor) {
                    if (floor - 1 == (cycle * 2) + 1) {
                        cycle++;
                        floor++;
                        idx += 4 * cycle;
                        break;
                    }

                    answer[idx] = value++;
                    floor--;
                }
            }

            if (floor + cycle == n) { // 최하단 층에 최초 도달했을 때
                for (int i = 0; i < floor - (cycle * 2); i++) {
                    answer[idx++] = value++;
                }

                continue;
            }

            if (value > blocks) { // 불필요한 아래 로직 방지 위한 탈출조건
                break;
            }

            answer[idx] = value;
            idx += floor;

            value++;
            floor++;
        }

        return answer;
    }

    public static int getAllBlocks(int n) {
        if (n == 1) {
            return 1;
        }

        return n + getAllBlocks(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
//        System.out.println(getAllBlocks(4));
//        System.out.println(getAllBlocks(5));
//        System.out.println(getAllBlocks(6));
    }
}
