package programmers.level2.멀쩡한사각형;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    public static long solution(int w, int h) {
        long gcd = getGcd(w, h);
        long all = (long) w * h;

        if (gcd == 1) {
            return all - (w + h - 1);
        }

        long tmpW = (long) w / gcd;
        long tmpY = (long) h / gcd;

        return all - gcd * (tmpW + tmpY - 1);
    }

    public static long getGcd(long m, long n) {
        if (n == 0) {
            return m;
        }

        return getGcd(n, m % n);
    }
}
