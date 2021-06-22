package programmers.level1.최대공약수와최소공배수;

public class Main {
    public static void main(String[] args) {
        int commonDivisor = getCommonDivisor(3, 12);
        int commonMultiple = (3 * 12) / commonDivisor;

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
     *  ref) 유클리드 호제법
     */
    public static int getCommonDivisor(int n, int m) {
        if (m == 0) {
            return n;
        }

        return getCommonDivisor(m, n % m);
    }
}
