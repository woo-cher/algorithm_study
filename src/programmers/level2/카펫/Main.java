package programmers.level2.카펫;

import java.util.Arrays;

/**
 * 제일 바깥쪽 테두리 (브라운 카펫)를 'ㄱ' 자 'ㄴ' 자로 분리해서 생각함
 * 'ㄱ' 자로 분리한 한 부분에서 가로, 세로 변수를 만듬
 * 세로의 길이는 1 이상이며, 가로보다 작거나 같음
 * 세로를 1부터 늘려가면서, 주어진 노랑카펫과 일치하는 구간에서 멈추고 리턴
 */
public class Main {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row, col = 1;

        while (true) {
            row = (brown / 2) - col;

            if (getYellow(row, col) == yellow) {
                answer[0] = row;
                answer[1] = col + 2;
                break;
            }

            col++;
        }

        return answer;
    }

    public static int getYellow(int x, int y) {
        return (x - 2) * y;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }
}
