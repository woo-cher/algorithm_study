package programmers.level1.신규아이디추천;

public class Main {
    public static void main(String[] args) {
        String test = "s@#3-...e.#2@_df.";
        String test2 = "12345";
        solution("123_.def");
    }

    public static String solution(String new_id) {
        String answer = "";

        answer = new_id
                .toLowerCase() // step 1
                .replaceAll("(?![a-z])(?![0-9])(?![-])(?![_])(?![.]).", "") // step 2
                .replaceAll("\\.\\.+", ".") // step 3
                .replaceAll("(?!\\w)[.]$", "") // step 4
                .replaceAll("^[.]{1}", "");

        // step 5
        if (answer.length() == 0) {
            answer = "a";
        }

        // step 6
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("(?!\\w)[.]$", "");
        }

        // step 7
        if (answer.length() < 3) {
            String last = String.valueOf(answer.charAt(answer.length() - 1));

            while (true) {
                if (answer.length() > 2) {
                    break;
                }

                answer += last;
            }
        }

        return answer;
    }
}
