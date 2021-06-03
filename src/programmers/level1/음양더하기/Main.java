package programmers.level1.음양더하기;

public class Main {
    public static void main(String[] args) {
        int[] ab = {4, 7, 12};
        boolean[] signs = {true, false, true};

        System.out.println(solution(ab, signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int i = 0;
        int sum = 0;

        for (int digit : absolutes) {
            if (!signs[i]) {
                digit *= -1;
            }
            sum += digit;
            i++;
        }

        return sum;
    }
}
