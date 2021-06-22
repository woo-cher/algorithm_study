package programmers.level1.최대공약수와최소공배수;

public class Main {
    public static void main(String[] args) {
        int n = 72;
        int m = 30;

        int commonDivisor = getCommonDivisor(n, m);
        int commonMultiple = (n * m) / commonDivisor;

        System.out.println(commonDivisor + ", " + commonMultiple);
    }

    public static int[] solution(int n, int m) {
        int[] answer = {};

        int commonDivisor = getCommonDivisor(n, m);
        int commonMultiple = (n * m) / commonDivisor;

        answer = new int[]{commonDivisor, commonMultiple};

        return answer;
    }

    /**
     *  - 유클리드 호제법
     *
     *  https://cheol-develop.tistory.com/3?category=971779
     */
    public static int getCommonDivisor(int n, int m) {
        if (m == 0) {
            return n;
        }

        return getCommonDivisor(m, n % m);
    }
}
