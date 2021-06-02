package programmers.level1.크레인인형뽑기게임;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[][] test = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println("result : " + solution(test, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        Stack<Integer> dollStack = new Stack<>();

        for (int move : moves) {
            int actual = 0;
            int parsedDoll = 0;

            for (int i = 0; i < size; i++) {
                int[] bucket = board[i];
                parsedDoll = bucket[move - 1];

                if (parsedDoll != 0) {
                    if (dollStack.size() > 0) {
                        actual = dollStack.peek();
                    }

                    bucket[move - 1] = 0; // fork doll
                    dollStack.push(parsedDoll); // put doll at stack

                    if (parsedDoll == actual) {
                        dollStack.pop();
                        dollStack.pop();
                        answer += 2;
                    }

                    break;
                }
            }
        }

        return answer;
    }
}
