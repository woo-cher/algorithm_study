package programmers.level2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String REGEX = "[a-zA-Z]";

    public static void main(String[] args) {
        String s1 = "12444";
        String s2 = "4456788";
        String s3 = "aa1+aa2";

        System.out.println(solution(s1, s2));
    }

    public static int solution(String str1, String str2) {
        List<String> multiSet1 = divide(str1);
        List<String> multiSet2 = divide(str2);

        return getJaccard(multiSet1, multiSet2);
    }

    public static int getJaccard(List<String> ms1, List<String> ms2) {
        double sum = .0;
        double common = .0;

        if (ms1.size() == 0 && ms2.size() == 0) {
            return 65536;
        }

        List<String> small = ms1.size() > ms2.size() ? ms2 : ms1;
        List<String> big = ms1.size() > ms2.size() ? ms1 : ms2;

        for (String el : small) {
            if (big.contains(el)) {
                common++;
                big.remove(el);
            }

            sum++;
        }

        sum += big.size();

        return (int) (common / sum * 65536);
    }

    public static List<String> divide(String s) {
        List<String> strs = new ArrayList<>();
        int size = s.length();

        for (int i = 0; i < size - 1; i++) {
            int end = i + 2;
            String slice = s.substring(i, end);

            if (slice.replaceAll(REGEX, "").isEmpty()) {
                strs.add(slice.toUpperCase());
            }
        }

        return strs;
    }
}
