package programmers.level2.영어끝말잇기;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Main {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> sets = new HashSet<>();

        String last = words[0].substring(words[0].length() - 1);
        sets.add(words[0]);

        int idx = 0;
        for (String word : words) {
            if (idx == 0) {
                idx++;
                continue;
            }

            if (!word.startsWith(last) || !sets.add(word)) {
                idx += 1;

                int order = idx / n + 1;
                int loser = idx % n;

                if (loser == 0) {
                    order -= 1;
                    loser = n;
                }

                answer[0] = loser;
                answer[1] = order;

                break;
            }

            last = word.substring(word.length() - 1);
            idx++;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
//        solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
//        solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
    }
}
