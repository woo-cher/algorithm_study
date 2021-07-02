package programmers.level2.짝지어제거하기;

/**
 * 스트링 연산이 많아서, 최대 100만개의 데이터를 처리하기엔 효율성이 떨어짐
 */
public class FirstTry {
    public static void main(String[] args) {
        solution("baabaa");
    }

    public static int solution(String s) {
        int answer = 0;
        int i = 0;
        String regex = "";

        if (s.length() % 2 != 0) {
            return 0;
        }

        while (true) {
            if (s.length() == 0) {
                answer = 1;
                break;
            }

            if (i == s.length() - 1) {
                answer = 0;
                break;
            }

            char c = s.charAt(i);

            if (c == s.charAt(i + 1)) {
                regex = String.valueOf(c).concat(String.valueOf(s.charAt(i + 1)));
                s = s.replaceAll(regex, "");
                i = 0;

                continue;
            }

            i++;
        }

        return answer;
    }
}
