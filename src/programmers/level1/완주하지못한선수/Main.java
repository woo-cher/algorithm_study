package programmers.level1.완주하지못한선수;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        String[] s1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] s2 = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(sub(s1, s2));
    }

    // 통과
    public static String sub(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }

    // 효율성 20점
    public static String sub2(String[] participant, String[] completion) {
        String answer = "";
        Map<Integer, String> cMap = new HashMap<>();

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for(String com : completion) {
            cMap.put(i++, com);
        }

        int j = 0;
        for(String joiner : participant) {
            if(!cMap.containsValue(joiner)) {
                answer = joiner;
                break;
            }
            cMap.remove(j++, joiner);
        }

        return answer;
    }

    // 효율성 Test 0
    public static String sub3(String[] participant, String[] completion) {
        String answer = "";
        List<String> cList = new CopyOnWriteArrayList(Arrays.asList(completion));
        for(String joiner : participant) {
            if(!cList.remove(joiner)) {
                answer = joiner;
                break;
            }
        }
        return answer;
    }
}
