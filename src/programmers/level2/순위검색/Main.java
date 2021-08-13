package programmers.level2.순위검색;

import java.util.*;

/**
 *  1. 하나의 정보에 대해서, info 값 하나 당 모든 경우의 조합을 구한다
 *  2. 모든 key 에 관한 entry (List<Integer>) 에 대하여, score 값을 오름차순 정렬한다
 *  3. 쿼리를 돌면서, 해당하는 key 값에 대하여 기준 점수를 기반으로 binary search
 */
public class Main {
    private static boolean[] v = {};
    private static Map<String, List<Integer>> database = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();

        for (String data : info) {
            String[] row = data.split(" ");
            v = new boolean[row.length];
            combination(row, v, "", 0);
        }

        // sort
        for (Map.Entry<String, List<Integer>> entry : database.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // query
        for (String el : query) {
            String[] q = el.split(" ");
            String key = q[0] + q[2] + q[4] + q[6];
            int score = Integer.parseInt(q[7]);

            if (database.containsKey(key)) {
                List<Integer> scores = database.get(key);
                int start = 0;
                int end = scores.size() - 1;

                while(start <= end) {
                    int mid = (start + end) / 2;

                    if(scores.get(mid) < score) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                answer.add(scores.size() - start);
            } else {
                answer.add(0);
            }
        }

        return answer.stream().mapToInt(n -> n).toArray();
    }

    public static void combination(String[] input, boolean[] v, String key, int depth) {
        if (depth == input.length - 1) { // score 전까지
            List<Integer> entry = database.getOrDefault(key, new ArrayList<>());
            entry.add(Integer.parseInt(input[input.length - 1]));
            database.put(key, entry);
            return;
        }

        // 데이터에 순서가 있기 때문에, int i = depth 부터
        // 보통의 조합 로직처럼 0 부터 시작하면, pizaa~~ 로 시작하는 경우와 150~~로 시작하는 경우 등을 모두 조합함
        for (int i = depth; i < input.length - 1; i++) {
            if (!v[i]) {
                v[i] = true;
                combination(input, v, key + input[i], depth + 1);
                combination(input, v, key + "-", depth + 1);
                v[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//        int[] answer = solution(info, query);

        System.out.println("");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(8);

        int score = 5;
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
