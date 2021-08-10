package programmers.level2.수식최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 60.0 / 100.0
 * 테스트 1 〉	통과 (13.17ms, 58.8MB)
 * 테스트 2 〉	통과 (13.11ms, 57.6MB)
 * 테스트 3 〉	실패 (13.99ms, 59.6MB)
 * 테스트 4 〉	통과 (14.37ms, 60.4MB)
 * 테스트 5 〉	통과 (23.42ms, 74MB)
 * 테스트 6 〉	통과 (17.35ms, 59.7MB)
 * 테스트 7 〉	실패 (22.08ms, 73MB)
 * 테스트 8 〉	실패 (16.43ms, 57.9MB)
 * 테스트 9 〉	통과 (20.64ms, 70.3MB)
 * 테스트 10 〉	통과 (18.74ms, 58.5MB)
 * 테스트 11 〉	실패 (22.93ms, 58.9MB)
 * 테스트 12 〉	실패 (20.90ms, 70.8MB)
 * 테스트 13 〉	실패 (27.66ms, 57.8MB)
 * 테스트 14 〉	실패 (21.35ms, 60.1MB)
 * 테스트 15 〉	실패 (21.65ms, 57.9MB)
 * 테스트 16 〉	통과 (17.02ms, 60.1MB)
 * 테스트 17 〉	통과 (13.86ms, 68.1MB)
 * 테스트 18 〉	통과 (11.47ms, 57.9MB)
 * 테스트 19 〉	통과 (18.35ms, 58.3MB)
 * 테스트 20 〉	통과 (13.79ms, 71.7MB)
 * 테스트 21 〉	통과 (12.79ms, 57.4MB)
 * 테스트 22 〉	통과 (13.45ms, 58MB)
 * 테스트 23 〉	통과 (11.68ms, 58MB)
 * 테스트 24 〉	실패 (20.75ms, 58.3MB)
 * 테스트 25 〉	통과 (19.91ms, 58.1MB)
 * 테스트 26 〉	통과 (16.81ms, 58.2MB)
 * 테스트 27 〉	실패 (20.15ms, 59.5MB)
 * 테스트 28 〉	실패 (14.70ms, 58.2MB)
 * 테스트 29 〉	실패 (15.16ms, 57.8MB)
 * 테스트 30 〉	통과 (15.73ms, 57.5MB)
 */
public class Fail {
    public static void main(String[] args) throws Exception {
//        String a = "50*6-3*2";
//        String b = "100-200*300-500+20";
//        String c = "-2-3-1+3*2";
//        String d = "100+500-600+700";
//        String f = "2*2*2*2*2-2*2*2";

//        System.out.println(solution(a));
//        System.out.println(solution(b));
//        System.out.println(solution(c));
//        System.out.println(solution(d));
//        System.out.println(solution(f));
    }

    public static long solution(String expression) throws Exception {
        long answer = 0;
        List<String> list = new ArrayList<>();
        List<String> cases = new ArrayList<>();

        String nonNumber = expression.replaceAll("[0-9]", "");

        for (int i = 0; i < nonNumber.length(); i++) {
            String sign = String.valueOf(nonNumber.charAt(i));

            if (!list.contains(sign)) {
                list.add(sign);
            }
        }

        permutation(list, cases, new StringBuffer(), new boolean[list.size()], 0);

        for (String signs : cases) {
            String result = expression;

            for (int i = 0; i < signs.length(); i++) {
                String sign = String.valueOf(signs.charAt(i));
                String regex = getRegex(sign);

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(result);

                while (matcher.find()) {
                    String match = matcher.group();

                    if (result.startsWith("-" + match)) {
                        match = "-".concat(match);
                    }

                    String temp = calculate(match, sign);
                    match = getWithEscape(match);
                    result = result.replaceFirst(match, temp)
                            .replace("--", "-")
                            .replace("\\+-", "-");

                    matcher = pattern.matcher(result);
                }
            }

            long abs = Math.abs(Long.parseLong(result));
            answer = Math.max(answer, abs);
        }

        return answer;
    }

    public static String calculate(String exp, String sign) {
        String regex = getWithEscape(sign);
        String[] nums = exp.split(regex);

        long num1, num2;

        if (nums.length > 2) { // When "-num1-num2"
            num1 = Long.parseLong(nums[1]) * -1;
            num2 = Long.parseLong(nums[2]);
        } else {
            num1 = Long.parseLong(nums[0]);
            num2 = Long.parseLong(nums[1]);
        }

        if (sign.equals("+")) {
            return String.valueOf(num1 + num2);
        } else if (sign.equals("-")) {
            return String.valueOf(num1 - num2);
        } else {
            return String.valueOf(num1 * num2);
        }
    }

    public static String getRegex(String sign) {
        String preFix = "[0-9]{1,10}";
        String postFix = "-?[0-9]{1,10}";
        sign = getWithEscape(sign);

        return preFix + sign + postFix;
    }

    public static String getWithEscape(String exp) {
        return exp.replace("*", "\\*")
                .replace("+", "\\+")
                .replace("-", "\\-");
    }

    public static void permutation(List<String> signs, List<String> cases, StringBuffer buffer, boolean[] visited, int depth) {
        if (depth == signs.size()) {
            cases.add(buffer.toString());
            return;
        }

        for (int i = 0; i < signs.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                buffer.replace(depth, depth + 1, signs.get(i));
                permutation(signs, cases, buffer, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
