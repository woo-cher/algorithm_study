package programmers.level1.K번째수;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] sub(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] ints;

        for(int i = 0; i < commands.length; i++) {
            ints = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(ints);
            answer[i] = ints[commands[i][2] - 1];
        }

        return answer;
    }
}
