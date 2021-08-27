package programmers.level2.위장;

import java.util.*;

public class Main {
    public static int solution(String[][] clothes) {
        int answer = 0;
        int[] input;
        Map<String, List<String>> clothMap = new HashMap<>();

        for (String[] cloth : clothes) {
            String category = cloth[1];
            String dress = cloth[0];

            List<String> list = clothMap.getOrDefault(category, new ArrayList<>());
            list.add(dress);

            clothMap.put(category, list);
        }

        // 동전 3개 경우를 구하는 것과 같음 : 2^3
        // 단, 모두 안입은 경우 제외
        if (clothMap.size() == clothes.length) {
            return (int) Math.pow(2, clothes.length) - 1;
        }

        input = new int[clothMap.size()];

        int i = 0;
        for (Map.Entry<String, List<String>> entry : clothMap.entrySet()) {
            input[i] = entry.getValue().size();
            i++;
        }

        for (int r = 1; r < input.length + 1; r++) {
            answer += comb(input, new boolean[input.length], 0, r);
        }

        return answer;
    }

    public static int comb(int[] input, boolean[] v, int start, int r) {
        int sum = 0;

        if (r == 0) {
            int result = 1;
            for (int i = 0; i < input.length; i++) {
                if (v[i]) {
                    result *= input[i];
                }
            }

            return result;
        }

        for (int i = start; i < input.length; i++) {
            v[i] = true;
            sum += comb(input, v, i + 1, r - 1);
            v[i] = false;
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] cloths = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"test", "test"}, {"h1", "headgear"}, {"test2", "test"}};
        String[][] cloths2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

//        System.out.println(solution(cloths));
        System.out.println(solution(cloths2));
    }
}
