package programmers.윤년;

public class Main {
    public static void main(String[] args) {
        System.out.println(sub(1, 21));
    }

    public static String sub(int a, int b) {
        String[] str = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] dayOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 0;
        int index = 5;
        int remain = 0;

        if (a == 1) {
            remain = (b - 1) % 7;
        } else {
            for (int i = 1; i < a; i++) {
                day += dayOfMonth[i];
            }
            remain = (day + b - 1) % 7;
        }

        if (remain == 0) {
            return "FRI";
        }

        for (; remain > 0; remain--) {
            if (index == str.length - 1) {
                index = -1;
            }
            index++;
        }

        return str[index];
    }
}