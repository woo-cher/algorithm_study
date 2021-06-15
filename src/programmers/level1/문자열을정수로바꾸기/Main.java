package programmers.level1.문자열을정수로바꾸기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("-0"));
    }

    public static int solution(String s) {
        int multiple = 1;

        if (!Character.isDigit(s.charAt(0))) {
            multiple = s.charAt(0) == '+' ? 1 : -1;
        }

        return multiple == -1 ?
                Integer.parseInt(s.substring(1)) * multiple :
                Integer.parseInt(s);
    }
}
