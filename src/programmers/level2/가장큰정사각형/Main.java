package programmers.level2.가장큰정사각형;

public class Main {
    public int solution(int[][] board) {
        int answer = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                int up = board[i - 1][j];
                int left = board[i][j - 1];
                int upperLeft = board[i - 1][j - 1];

                board[i][j] = Math.min(Math.min(up, left), upperLeft);
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}
