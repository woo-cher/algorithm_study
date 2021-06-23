package programmers.level1.하샤드수;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean solution(int x) {
        String toStr = String.valueOf(x);
        int sum = 0;
        int i = 0;

        while (true) {
            if (i == toStr.length()) {
                break;
            }

            sum += toStr.charAt(i) - '0';
            i++;
        }

        if (x % sum == 0) {
            return true;
        }

        return false;
    }
}
