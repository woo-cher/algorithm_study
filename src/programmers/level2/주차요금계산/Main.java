package programmers.level2.주차요금계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static final String ONE_DAY = "23:59";
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        PriorityQueue<String> cars = new PriorityQueue<>();
        Map<String, Integer> feeMap = new HashMap<>();
        Map<String, String> parkMap = new HashMap<>();

        for (String s : records) {
            String[] arr = s.split(" ");

            String time = arr[0];
            String car = arr[1];
            String action = arr[2];

            // In process
            if (action.equals("IN")) {
                if (!feeMap.containsKey(car)) {
                    feeMap.put(car, 0);
                }

                if (!cars.contains(car)) {
                    cars.add(car);
                }

                parkMap.put(car, time);
                continue;
            }

            // Out process
            String startTime = parkMap.get(car);

            int newTime = feeMap.getOrDefault(car, 0);
            newTime += getSubtractedTime(startTime, time);

            feeMap.put(car, newTime);
            parkMap.remove(car);
        }

        // if there is a car that has not `OUT`
        for (Map.Entry<String, String> entry : parkMap.entrySet()) {
            String startTime = entry.getValue();
            int newTime = feeMap.getOrDefault(entry.getKey(), 0);
            newTime += getSubtractedTime(startTime, ONE_DAY);

            feeMap.put(entry.getKey(), newTime);
        }

        // calculate fee
        for (Map.Entry<String, Integer> entry : feeMap.entrySet()) {
            int fee = getTotalFee(fees, entry.getValue());
            feeMap.put(entry.getKey(), fee);
        }

        // set `answer` order by `car number` desc
        answer = new int[cars.size()];
        int i = 0;
        while (!cars.isEmpty()) {
            answer[i++] = feeMap.get(cars.poll());
        }

        return answer;
    }

    private static Integer getSubtractedTime(String start, String end) {
        String[] arr1 = start.split(":");
        String[] arr2 = end.split(":");

        int t1 = Integer.parseInt(arr1[0]) * 60 + Integer.parseInt(arr1[1]);
        int t2 = Integer.parseInt(arr2[0]) * 60 + Integer.parseInt(arr2[1]);

        return Math.abs(t1 - t2);
    }

    private static int getTotalFee(int[] fees, int time) {
        if (time <= fees[0]) {
            return fees[1];
        }

        double f = (time - (double) fees[0]) / (double) fees[2];
        return (int) (fees[1] + Math.ceil(f) * fees[3]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}))
        );

        System.out.println(Arrays.toString(
                solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}))
        );

        System.out.println(Arrays.toString(
                solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}))
        );
    }
}
