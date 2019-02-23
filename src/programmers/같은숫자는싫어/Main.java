package programmers.같은숫자는싫어;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        sub(arr);
    }

    public static int[] sub(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int p = arr[0];
        list.add(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(p != arr[i]) {
                p = arr[i];
                list.add(arr[i]);
            }
        }
        // Convert List<Integer> to int[]
        return list.stream().mapToInt(i -> i).toArray();
    }
}
