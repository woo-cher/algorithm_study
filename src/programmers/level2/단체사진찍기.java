package programmers.level2;

/**
 * 순열 (permutation) 기법
 */
public class 단체사진찍기 {
    private static final int ALL_FRIENDS = 8;
    private static int cases = 40320; // 8!

    public static void main(String[] args) {
        int n = 2;
        String[] data = new String[]{"N~F=0", "R~T>2"};
        String[] data2 = new String[]{"M~C<2", "C~M>1"};

        System.out.println(solution(n, data));

        cases = 40320;
        System.out.println(solution(n, data2));
    }

    public static int solution(int n, String[] data) { // n = 조건의 개수
        if (n == 0) {
            return cases;
        }

        String[] kakaoFriends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        StringBuffer buffer = new StringBuffer();

        boolean[] visited = new boolean[ALL_FRIENDS];

        permutation(kakaoFriends, data, buffer, visited, 0);

        return cases;
    }

    public static void permutation(String[] input, String[] conditions, StringBuffer buffer, boolean[] visited, int depth) {
        if (depth == ALL_FRIENDS) {
            validate(buffer, conditions);
            return;
        }

        for (int i = 0; i < ALL_FRIENDS; i++) { // i => fix 할 idx
            if (!visited[i]) {
                visited[i] = true;
                buffer.replace(depth, depth + 1, input[i]);
                permutation(input, conditions, buffer, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void validate(StringBuffer buffer, String[] conditions) {
        boolean validated = false;

        for (String condition : conditions) {
            String c1 = String.valueOf(condition.charAt(0));
            String c2 = String.valueOf(condition.charAt(2));
            String sign = String.valueOf(condition.charAt(3));
            int value = condition.charAt(4) - '0';

            int distance = Math.abs(buffer.indexOf(c1) - buffer.indexOf(c2)) - 1;

            switch (sign) {
                case "=":
                    validated = distance == value;
                    break;
                case ">":
                    validated = distance > value;
                    break;
                case "<":
                    validated = distance < value;
                    break;
            }

            if (!validated) {
                cases--;
                break;
            }
        }
    }
}
