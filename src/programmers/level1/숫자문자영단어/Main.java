package programmers.level1.숫자문자영단어;

public class Main {
    public static final String[] mapper = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static int solution(String s) {
        int num = 0;

        for (String str : mapper) {
            s = s.replaceAll(str, String.valueOf(num++));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
}
