package programmers.level1.소수구하기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  1. 배열 sort 함수로 정렬
 *  2. arr[0-2] 의 합이 최솟값, arr[끝에서 3칸] 의 합이 최댓값
 *  3. min <= decimal <= max 사이의 모든 소수를 구한다
 *  4. 주어진 num 배열을 중복없이 3개 합한 값이 소수인지를 판별
 */
public class Main {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 2, 7, 6, 4});
        System.out.println("re : " + result);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        int max = 0;
        int min = 0;
        Map<Integer, Integer> decimalMap = new HashMap<>();

        Arrays.sort(nums);

        if (size == 3) {
            min = 6;
            max = nums[0] + nums[1] + nums[2];
        } else {
            min = nums[0] + nums[1] + nums[2];
            max = nums[size - 3] + nums[size - 2] + nums[size - 1];
        }

        for (int i = min; i <= max; i++) {
            boolean isDecimal = true;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    isDecimal = false;
                    break;
                }
            }

            if (isDecimal) {
                decimalMap.put(i, i);
            }
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }

        System.out.println("\nmap : " + decimalMap);
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    int matcher = nums[i] + nums[j] + nums[k];
                    if (decimalMap.containsKey(matcher)) {
                        System.out.println(i + ", " + j + ", " + k + "");
                        System.out.println("matcher : " + matcher);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
