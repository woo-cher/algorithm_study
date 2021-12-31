package programmers.level2.n진수게임_3차;

public class Main {
    public static String solution(int n, int t, int m, int p) { // 진수, 구할 개수, 참가 인원, 튜브의 순서
        String answer = "";

        StringBuilder sb = new StringBuilder();
        StringBuilder tubeStr = new StringBuilder();

        for (int i = 0; i < m * t; i++) {
            sb.append(Integer.toString(i, n));
        }

        int i = p - 1;
        while (tubeStr.length() < t) {
            tubeStr.append(sb.charAt(i));

            i += m;
        }

        answer = tubeStr.toString().toUpperCase();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }
}
