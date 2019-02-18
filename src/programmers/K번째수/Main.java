package programmers.K번째수;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] c = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] val = sub(a, c);
        for (int i : val) {
            System.out.print(i + " ");
        }
    }

    public static int[] sub(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        String s = "";
        List<Integer> list;

        // initialize
        for (int i : array) {
            s += String.valueOf(i);
        }

        for (int i = 0; i < commands.length; i++) {
            list = new ArrayList();
            String s2 = s.substring(commands[i][0] - 1, commands[i][1]);
            for (int j = 0; j < s2.length(); j++) {
                list.add(s2.charAt(j) - '0');
            }
            Collections.sort(list);
            answer[index] = list.get(commands[i][2] - 1);
            index++;
        }
        return answer;
    }
}