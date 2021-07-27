package programmers.level2.전화번호목록;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] books = {"123", "456", "789"};
        String[] books2 = {"119", "11892", "119923", "116443"};

        System.out.println(solution2(books2));
    }

    public static boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(phoneBook));

        for (String actual : set) {
            for (int i = 1; i < actual.length(); i++) {
                if (set.contains(actual.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solution2(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                return false;
            }
        }

        return true;
    }

    // fail
    public static boolean solution3(String[] phoneBook) {
        Arrays.sort(phoneBook, Comparator.comparingInt(String::length));

        for (int i = 0; i < phoneBook.length; i++) {
            String actual = phoneBook[i];

            for (int j = i + 1; j < phoneBook.length; j++) {
                String matcher = phoneBook[j];

                if (matcher.startsWith(actual)) {
                    return false;
                }
            }
        }

        return true;
    }
}
