package programmers.모의고사;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제가 명확하게 정의되어 있지 않다.
 * 예제 출력값이 유효하지 않다.
 */
public class Main {
    public static void main(String[] args) {
        //int[] arr = sub(new int[]{1,2,3,4,5});
        int[] arr = sub(new int[]{1,3,2,4,1});
        for(int i : arr) {
            System.out.println(i);
        }
    }

    // Brute-force
    public static int[] sub(int[] answers) {
        int[] answer = {};
        Person p1 = new Person("12345");
        Person p2 = new Person("21232425");
        Person p3 = new Person("3311224455");

        List<Person> personLIst = new ArrayList<>();
        personLIst.add(p1);
        personLIst.add(p2);
        personLIst.add(p3);

        String[] str = {"12345", "21232425", "3311224455"};

        for (int i = 0; i < str.length; i++) {
            int addr = 0;
            for (int j = 0; j < answers.length; j++) {
                if (addr > str[i].length()) {
                    addr = 0;
                }
                if (str[i].charAt(addr) - '0' == answers[j]) {
                    int score = personLIst.get(i).getScore();
                    personLIst.get(i).setScore(++score);
                }
                addr++;
            }
        }

        return answer;
    }
}

class Person {
    private String pattern;
    private int score;
    private int rank;

    Person() {}

    public Person(String pattern) {
        this.pattern = pattern;
        this.score = 0;
    }

    public Person(String pattern, int score) {
        this.pattern = pattern;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}