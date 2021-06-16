package programmers.level1.이상한문자만들기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("try hello world      "));
        System.out.println(solution("try    hello    world     "));
    }


    public static String solution(String s) {
        String[] words = s.split(" ", 0);
        String answer = "";

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);

                if (j % 2 == 0) {
                    answer += Character.toUpperCase(ch);
                } else {
                    answer += Character.toLowerCase(ch);
                }
            }

            if (i != words.length - 1) {
                answer += " ";
            }
        }

        return answer;
    }
}
