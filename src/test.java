import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String s = "12345";
        System.out.println(s.charAt(5));
        System.out.println(s.length());
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
