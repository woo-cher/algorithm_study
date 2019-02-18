package programmers.완주하지못한선수;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        String[] s1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] s2 = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(sub2(s1, s2));
    }

    public static String sub(String[] participant, String[] completion) {
        String answer = "";
        List<String> completionList = new CopyOnWriteArrayList<>(Arrays.asList(completion));
        for (String p : participant) {
            if (!completionList.contains(p)) {
                answer = p;
                break;
            }
            completionList.remove(p);
        }
        return answer;
    }

    public static String sub2(String[] participant, String[] completion) {
        String answer = "";
        List<String> pList = Arrays.asList(participant);
        List<String> cList = Arrays.asList(completion);
        Map<Integer, String> completionMap = new HashMap<>();

        Arrays.sort(participant);
        Arrays.sort(completion);

        // initialize
        int index = 0;
        for (String c : cList) {
            completionMap.put(index, c);
            index++;
        }

        // parse
        int i = 0;
        for (String p : pList) {
            if (!completionMap.containsValue(p)) {
                answer = p;
                break;
            }
            if (i == 0 || p == completionMap.get(i)) {
                completionMap.remove(i);
            }
            else if (pList.get(i) != cList.get(i-1)) {
                answer = p;
                break;
            }
            i++;
        }
        return answer;
    }
}