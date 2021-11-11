package programmers.level2.이진변환반복하기;

public class Main {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int remove = 0;

        while (!s.equals("1")) {
            String s2 = s.replaceAll("0", "");
            remove += (s.length() - s2.length());
            s = Integer.toBinaryString(s2.length());
            cnt++;
        }

        answer[0] = cnt;
        answer[1] = remove;

        return answer;
    }
}
