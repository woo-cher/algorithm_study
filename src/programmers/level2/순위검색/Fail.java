package programmers.level2.순위검색;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (6.40ms, 74.2MB)
 * 테스트 2 〉	통과 (4.22ms, 60MB)
 * 테스트 3 〉	통과 (16.13ms, 77.5MB)
 * 테스트 4 〉	통과 (46.02ms, 86.2MB)
 * 테스트 5 〉	통과 (82.60ms, 99.3MB)
 * 테스트 6 〉	통과 (97.25ms, 86.7MB)
 * 테스트 7 〉	통과 (79.79ms, 82.2MB)
 * 테스트 8 〉	통과 (168.37ms, 125MB)
 * 테스트 9 〉	통과 (272.56ms, 125MB)
 * 테스트 10 〉	통과 (271.90ms, 125MB)
 * 테스트 11 〉	통과 (142.10ms, 96.8MB)
 * 테스트 12 〉	통과 (110.65ms, 82.9MB)
 * 테스트 13 〉	통과 (117.38ms, 84.1MB)
 * 테스트 14 〉	통과 (184.82ms, 124MB)
 * 테스트 15 〉	통과 (247.31ms, 123MB)
 * 테스트 16 〉	통과 (82.56ms, 97.1MB)
 * 테스트 17 〉	통과 (169.69ms, 87.4MB)
 * 테스트 18 〉	통과 (214.58ms, 106MB)
 *
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 */
public class Fail {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(Integer.compare(1, 2));
        System.out.println(Integer.compare(2, 2));
        System.out.println(Integer.compare(2, 1));

        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] answer = solution(info, query);

        System.out.println("dddddddd");
    }

    public static int[] solution(String[] info, String[] query) throws IllegalAccessException {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<Person>> database = new HashMap<>();

        for (String data : info) {
            String[] keys = data.split(" ");
            Person person = new Person(keys[0], keys[1], keys[2], keys[3], keys[4]);

            int idx = 0;
            for (String key : keys) {
                List<Person> list;

                if (idx == keys.length - 1) {
                    list = database.getOrDefault("score", new ArrayList<>());
                    list.add(person);
                    database.put("score", list);
                    break;
                }

                list = database.getOrDefault(key, new ArrayList<>());
                list.add(person);

                database.put(key, list);
                idx++;
            }
        }

        for (String q : query) {
            List<String> conditions = getConditions(q.split(" and "));
            int firstKey = getFirstKeyIndex(conditions);
            List<Person> datas = database.getOrDefault(conditions.get(firstKey), database.get("score"));

            int cnt = validate(datas, conditions, firstKey);
            answer.add(cnt);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static List<String> getConditions(String[] conditions) {
        List<String> list = new ArrayList<>();

        int i = 0;
        for (String c : conditions) {
            if (i == conditions.length - 1) {
                list.addAll(Arrays.asList(c.split(" ")));
                break;
            }

            list.add(c);
            i++;
        }

        return list;
    }

    public static int validate(List<Person> datas, List<String> conditions, int startKey) throws IllegalAccessException {
        int valid = 0;
        int start = startKey != 4 ? startKey + 1 : startKey;

        for (Person p : datas) {
            boolean isValid = true;
            Field[] fields = p.getClass().getDeclaredFields();

            for (int i = start; i < conditions.size(); i++) {
                String c = conditions.get(i);
                String matcher = (String) fields[i].get(p);

                if (c.equals("-")) {
                    continue;
                }

                if (i == conditions.size() - 1) {
                    int r = Integer.compare(Integer.parseInt(c), Integer.parseInt(matcher));
                    if (r > 0) {
                        isValid = false;
                        break;
                    }
                } else if (!c.equals(matcher)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                valid++;
            }
        }

        return valid;
    }

    public static int getFirstKeyIndex(List<String> conditions) {
        int i = 0;
        for (String condition : conditions) {
            if (!condition.equals("-")) {
                return i;
            }
            i++;
        }

        return i;
    }
}

class Person {
    public String lan;
    public String job;
    public String car;
    public String soulFood;
    public String score;

    public Person(String lan, String job, String car, String soulFood, String score) {
        this.lan = lan;
        this.job = job;
        this.car = car;
        this.soulFood = soulFood;
        this.score = score;
    }
}
