package programmers.level2.스킬트리;

public class Main {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String s : skill_trees) {
            if (isValid(skill, s)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isValid(String skill, String s) {
        int limit = 0;

        for (int i = 0; i < s.length(); i++) {
            String matcher = s.charAt(i) + "";

            if (skill.contains(matcher)) {
                String skillRange = skill.substring(0, limit + 1);

                if (!skillRange.contains(matcher)) {
                    return false;
                }

                limit++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
